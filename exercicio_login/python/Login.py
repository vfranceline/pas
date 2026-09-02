class Login:
    def __init__(self, nome, senha):
        self.nome = nome
        self.senha = senha

    def getNome(self):
        return self.nome

    def getSenha(self):
        return self.senha

    def verificarLogin(self, nome, senha):
        return True if (self.nome == nome) and (self.senha == senha) else False