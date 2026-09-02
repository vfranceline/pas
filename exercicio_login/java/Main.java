package exercicio_login.java;

public class Main {
    public static void main(String[] args){
    // Escreva um programa que crie uma instâncias da classe Login com o seguinte estado respectivamente
    // nome = eduardo e senha = 123. Em seguida imprima o valor de retorno do método verificaLogin com os
    // parâmetros nome= carlos e senha =123.
        Login login = new Login("eduardo", "123");

        System.out.println(login.verificaLogin("carlos", "123"));

        // Crie uma instância da classe LoginEspecial utilizando uma variável do tipo Login. E imprima a sua 
        // dica, usando o método getDica().

        Login login_especial = new LoginEspecial("vit", "1005", "aniversario");

        System.out.println(((LoginEspecial) login_especial).getDica());
    }
}
