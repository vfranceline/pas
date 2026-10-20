package login;

public abstract class Login {
    public Object autentica(String usuarioID, String senha){
        String mensagem;
        if ("aluno".equals(usuarioID) && "123".equals(senha)){
            mensagem = "sucesso";
        } else {
            mensagem = "algo invalido";
        }
        notificaAutenticacao
    }
}
