import sys
import socket
import threading
import datetime

sys.path.append('./client')
from client_model import Client

sys.path.append('./database')
from database.database import Database

class Server:
    def __init__(self, host, port, max_clients):
        self.__host = host
        self.__port = port
        self.__max_clients = max_clients
        self.__server_socket = None
        self.__clients = []

    def initialize(self):
        try:
            self.__server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            self.__server_socket.bind((self.__host, self.__port))
            print('Uploading server...')
            self.__server_socket.listen(self.__max_clients)
            print(f'Server listening on {self.__host}:{self.__port}. Max. clients:  {self.__max_clients} .')

            while True:
                if len(self.__clients) < self.__max_clients:
                    conn, addr = self.__server_socket.accept()
                    client = ClientConnection(conn, addr, self)
                    client.start()
                    self.__clients.append(client)
                else:
                    print('Server busy. Unable to accept new connections. You can close another one.')

        except Exception as ex:
            print('An error occurred during server initialization:', ex)

    def initialize_db(self):
        try:
            db = Database('127.0.0.1', 5432, 'matheus', 'postgres', 'postgres')
        except Exception as ex:
            print('An error occurred during database initialization:', ex)

    def broadcast_message(self, message, sender):
        for client in self.__clients:
            if client != sender:  # Evita enviar a mensagem de volta para o remetente
                client.send_message(message)

    def remove_client(self, client):
        self.__clients.remove(client)

    def close(self):
        if self.__server_socket:
            self.__server_socket.close()

class ClientConnection(threading.Thread):
    def __init__(self, conn, addr, server):
        super().__init__()
        self.__conn = conn
        self.__addr = addr
        self.__server = server
        self.__client = Client(self)  # Cria uma instância de cliente correspondente a esta conexão

    def run(self):
        print(f'New connetion from: {self.__addr}')

        while True:
            data = self.__conn.recv(1024).decode()

            if data == 'exit':
                print(f'Client {self.__addr} disconnected.')
                self.__conn.close()
                self.__server.remove_client(self)
                break
            
            print(f'Client {self.__addr}: {data}')
            self.__server.broadcast_message(data, self)

    def send_message(self, message):
        self.__conn.sendall(message.encode())

# Exemplo de uso:
if __name__ == "__main__":
    server = Server('localhost', 7007, 3)
    server.initialize()