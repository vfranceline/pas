package observer;

public class FuncionarioCozinha implements Observador {
    private final String nome;

    public FuncionarioCozinha(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println("[Notificação para " + nome + "] " + mensagem);
    }
}
