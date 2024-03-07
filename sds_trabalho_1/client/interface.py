import tkinter as tk
from tkinter import ttk

class Interface:
    def __init__(self, notebook, controlador):
        self.controlador = controlador

        # Aba Cadastrar
        self.aba_cadastrar = ttk.Frame(notebook)
        notebook.add(self.aba_cadastrar, text='Cadastrar')
        self.criar_aba_cadastrar()

        # Aba Buscar
        self.aba_buscar = ttk.Frame(notebook)
        notebook.add(self.aba_buscar, text='Buscar')
        self.criar_aba_buscar()

        # Aba Alterar
        self.aba_alterar = ttk.Frame(notebook)
        notebook.add(self.aba_alterar, text='Alterar')
        self.criar_aba_alterar()

        # Aba Listar
        self.aba_listar = ttk.Frame(notebook)
        notebook.add(self.aba_listar, text='Listar')
        self.criar_aba_listar()

        # Aba Deletar
        self.aba_deletar = ttk.Frame(notebook)
        notebook.add(self.aba_deletar, text='Deletar')
        self.criar_aba_deletar()

    def criar_aba_cadastrar(self):
        rotulo_nome = ttk.Label(self.aba_cadastrar, text="Nome:")
        rotulo_nome.grid(row=0, column=0, padx=10, pady=5, sticky="w")
        self.entrada_nome = ttk.Entry(self.aba_cadastrar)
        self.entrada_nome.grid(row=0, column=1, padx=10, pady=5)

        rotulo_cpf = ttk.Label(self.aba_cadastrar, text="CPF:")
        rotulo_cpf.grid(row=1, column=0, padx=10, pady=5, sticky="w")
        self.entrada_cpf = ttk.Entry(self.aba_cadastrar)
        self.entrada_cpf.grid(row=1, column=1, padx=10, pady=5)

        rotulo_endereco = ttk.Label(self.aba_cadastrar, text="Endereço:")
        rotulo_endereco.grid(row=2, column=0, padx=10, pady=5, sticky="w")
        self.entrada_endereco = ttk.Entry(self.aba_cadastrar)
        self.entrada_endereco.grid(row=2, column=1, padx=10, pady=5)

        botao_cadastrar = ttk.Button(self.aba_cadastrar, text="Cadastrar", command=self.controlador.cadastrar_paciente)
        botao_cadastrar.grid(row=3, columnspan=2, padx=10, pady=5)

    def criar_aba_buscar(self):
        rotulo_busca_cpf = ttk.Label(self.aba_buscar, text="CPF:")
        rotulo_busca_cpf.grid(row=0, column=0, padx=10, pady=5, sticky="w")
        self.entrada_busca_cpf = ttk.Entry(self.aba_buscar)
        self.entrada_busca_cpf.grid(row=0, column=1, padx=10, pady=5)

        botao_buscar = ttk.Button(self.aba_buscar, text="Buscar", command=self.controlador.buscar_paciente)
        botao_buscar.grid(row=1, columnspan=2, padx=10, pady=5)

    def criar_aba_alterar(self):
        # Aba Alterar
        rotulo_nome = ttk.Label(self.aba_alterar, text="Nome:")
        rotulo_nome.grid(row=0, column=0, padx=10, pady=5, sticky="w")
        self.entrada_nome_alterar = ttk.Entry(self.aba_alterar)
        self.entrada_nome_alterar.grid(row=0, column=1, padx=10, pady=5)

        rotulo_cpf = ttk.Label(self.aba_alterar, text="CPF:")
        rotulo_cpf.grid(row=1, column=0, padx=10, pady=5, sticky="w")
        self.entrada_cpf_alterar = ttk.Entry(self.aba_alterar)
        self.entrada_cpf_alterar.grid(row=1, column=1, padx=10, pady=5)

        rotulo_endereco = ttk.Label(self.aba_alterar, text="Endereço:")
        rotulo_endereco.grid(row=2, column=0, padx=10, pady=5, sticky="w")
        self.entrada_endereco_alterar = ttk.Entry(self.aba_alterar)
        self.entrada_endereco_alterar.grid(row=2, column=1, padx=10, pady=5)

        botao_alterar = ttk.Button(self.aba_alterar, text="Alterar", command=self.controlador.alterar_paciente)
        botao_alterar.grid(row=3, columnspan=2, padx=10, pady=5)

    def criar_aba_listar(self):
        # Aba Listar
        self.tabela_listar = ttk.Treeview(self.aba_listar, columns=("Nome", "CPF", "Endereço"), show="headings")
        self.tabela_listar.heading("Nome", text="Nome")
        self.tabela_listar.heading("CPF", text="CPF")
        self.tabela_listar.heading("Endereço", text="Endereço")
        self.tabela_listar.grid(row=0, column=0, padx=10, pady=5)

        botao_atualizar = ttk.Button(self.aba_listar, text="Atualizar", command=self.atualizar_tabela)
        botao_atualizar.grid(row=1, column=0, padx=10, pady=5)

    def criar_aba_deletar(self):
        # Aba Deletar
        rotulo_cpf_deletar = ttk.Label(self.aba_deletar, text="CPF:")
        rotulo_cpf_deletar.grid(row=0, column=0, padx=10, pady=5, sticky="w")
        self.entrada_cpf_deletar = ttk.Entry(self.aba_deletar)
        self.entrada_cpf_deletar.grid(row=0, column=1, padx=10, pady=5)

        botao_deletar = ttk.Button(self.aba_deletar, text="Deletar", command=self.controlador.deletar_paciente)
        botao_deletar.grid(row=1, columnspan=2, padx=10, pady=5)

    def atualizar_tabela(self):
        # Preencher a tabela com dados do controlador
        pass

    def fechar_interface(self):
        pass
