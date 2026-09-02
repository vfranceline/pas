package exercicio_login.java;

public class LoginEspecial extends Login{
    // Escreva  uma  classe  LoginEspecial  que  herda  da classe  Login  e  acrescenta  o  atributo  dica  ( 
    // variável de instância privada).  
    // • O  construtor  deve  definir  o  atributo  dica  e usar o construtor da superclasse para definir 
    // os demais atributos (nome e senha) 
    // • Esta classe deverá possuir o método public String getDica().

    private String dica;

    public LoginEspecial(String nome, String senha, String dica){
        super(nome, senha);
        this.dica = dica;
    }

    public String getDica(){
        return this.dica;
    }

}
