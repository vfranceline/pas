from Login import Login
from LoginEspecial import LoginEspecial

def main():
    # Escreva um programa que crie uma instâncias da classe Login com o seguinte estado respectivamente
    # nome = eduardo e senha = 123. Em seguida imprima o valor de retorno do método verificaLogin com os
    # parâmetros nome= carlos e senha =123.
    login = Login("eduardo", "123")

    print(login.verificarLogin("carlos", "123"))

    # Crie uma instância da classe LoginEspecial utilizando uma variável do tipo Login. E imprima a sua 
    # dica, usando o método getDica().
    login_especial = LoginEspecial("vit", "1005", "aniversario")
    print(login_especial.getDica())

if __name__ == "__main__":
    main()
