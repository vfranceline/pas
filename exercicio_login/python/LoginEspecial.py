from Login import Login

    # Escreva  uma  classe  LoginEspecial  que  herda  da classe  Login  e  acrescenta  o  atributo  dica  ( 
    # variável de instância privada).  
    # • O  construtor  deve  definir  o  atributo  dica  e usar o construtor da superclasse para definir 
    # os demais atributos (nome e senha) 
    # • Esta classe deverá possuir o método public String getDica().
class LoginEspecial(Login) :
    def __init__(self, nome, senha, dica):
        super().__init__(nome, senha)
        self.dica = dica

    def getDica(self):
        return self.dica