from client_model import Client

class Controlador:
    __client : Client

    def __init__(self, client_name):
        self.__client = Client(client_name)
        #self.__client.connect_to_server('127.0.0.1', 7007)

    def cadastrar_paciente(self):
        print("Cadastrar paciente")

    def buscar_paciente(self):
        print("Buscar paciente")

    def alterar_paciente(self):
        print("Alterar paciente")

    def listar_pacientes(self):
        print("Listar pacientes")

    def deletar_paciente(self):
        print("Deletar paciente")