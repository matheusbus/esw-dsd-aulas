import socket

class Client:
    __client_socket : socket

    def __init__(self, name):
        self.__name = name

    def get_name(self):
        return self.__name

    def set_name(self, name):
        self.__name = name
    
    def connect_to_server(self, host, port):
        try :
            self.__client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            self.__client_socket.connect((host, port))
            self.__client_socket.sendall(self.__name.encode())
        except Exception as ex:
            print('An error occurred while trying to connect to the server: ', ex)

    def send_message(self, message):
        self.__client_socket.sendall(message.encode())
    
    def receive_message(self):
        return self.__client_socket.recv(1024).decode()

# Exemplo de uso:
if __name__ == "__main__":
    client = Client('Matheus')
    client.connect_to_server('localhost', 12345)
    message = ''
    while message != 'exit':
        message = input("Digite sua mensagem: ")
        client.send_message(message)
        if message.lower() == 'bye':
            break
    client.close_connection()