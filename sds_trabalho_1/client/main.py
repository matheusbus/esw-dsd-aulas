# Implementar lógica do lado do cliente
# --> Possível formulário com todas as operações que o cliente pode realizar no servidor
'''
option : str = '0'
while(option != '6'):
    print('Bem-vindo ao sistema!')

    option = input('Digite a operação que deseja executar (1-INSERT, 2-UPDATE, 3-GET, 4-LIST, 5-DELETE, 6-SAIR):' )
    while option not in [1,2,3,4,5]:
        option = input('Operação digitava é inválida. Digite uma das opções: (1-INSERT, 2-UPDATE, 3-GET, 4-LIST, 5-DELETE, 6-SAIR): ')
'''
    
import tkinter as tk
from tkinter import ttk
from interface import Interface
from controlador import Controlador

def configurar_estilo_notebook():
    # Cria um estilo
    estilo = ttk.Style()
    estilo.theme_use('xpnative')

    # Configura o plano de fundo do Notebook
    estilo.configure('EstiloNotebook.TNotebook', background='lightblue')

def main():
    client_name = input('Digite seu nome: ')

    # Instanciar o controlador
    controlador = Controlador(client_name)

    # Criar janela principal
    janela = tk.Tk()
    janela.title("Cadastro de Pacientes")

    # Criar e adicionar abas
    notebook = ttk.Notebook(janela, style='EstiloNotebook.TNotebook')
    notebook.pack(fill='both', expand=True)

    # Configurar estilo do Notebook
    configurar_estilo_notebook()

    # Instanciar a interface
    interface = Interface(notebook, controlador)

    # Executar a janela
    janela.mainloop()

if __name__ == '__main__':
    main()