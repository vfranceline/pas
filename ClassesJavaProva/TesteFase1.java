public class TesteFase1 {

    private static class TituloTeste extends Titulo {

        public TituloTeste(String descricao, double valor, int vencimento) {
            super(descricao, valor, vencimento);
        }

        @Override
        public boolean Pagamento(int dataAtual, String newConta) {
            return false;
        }
    }

    public static void main(String[] args) {
        Titulo titulo = new TituloTeste("Titulo para teste", 500.00, 20);
        Titulo mesmoTitulo = new TituloTeste("Titulo para teste", 999.00, 40);
        Titulo outroTitulo = new TituloTeste("Outra descricao", 500.00, 20);

        TesteUtil.verificarIgual("Aberto", titulo.getEstado(), "Estado inicial incorreto");
        TesteUtil.verificar(!titulo.Vencido(15), "Titulo nao deveria estar vencido");
        TesteUtil.verificar(!titulo.Vencido(20), "No vencimento, o titulo ainda nao esta vencido");
        TesteUtil.verificar(titulo.Vencido(25), "Titulo deveria estar vencido");
        TesteUtil.verificar(titulo.equals(mesmoTitulo),
                "Titulos com a mesma descricao devem ser iguais");
        TesteUtil.verificar(!titulo.equals(outroTitulo),
                "Titulos com descricoes diferentes nao devem ser iguais");

        TesteUtil.verificar(titulo.Cancela(15), "Cancelamento deveria ser permitido");
        TesteUtil.verificarIgual("Cancelado", titulo.getEstado(), "Estado deveria ser Cancelado");

        System.out.println("FASE 1 APROVADA - Classe Titulo e criterio de igualdade validados.");
    }
}
