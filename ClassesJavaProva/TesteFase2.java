public class TesteFase2 {
    public static void main(String[] args) {
        TituloP titulo = new TituloP(
            "Pagamento de energia", 320.50, 20, "Companhia de Energia"
        );

        TesteUtil.verificarIgual("Companhia de Energia", titulo.getFornecedor(),
            "Fornecedor incorreto");
        TesteUtil.verificar(titulo.Pagamento(18, "98765-4"),
            "Pagamento deveria ser realizado");
        TesteUtil.verificarIgual("Quitado", titulo.getEstado(),
            "Estado deveria ser Quitado");
        TesteUtil.verificar(titulo.getBancario() != null,
            "Lancamento bancario nao foi criado");
        TesteUtil.verificarDouble(320.50, titulo.getBancario().getValor(),
            "Valor do debito incorreto");
        TesteUtil.verificarIgual("Debito", titulo.getBancario().getTipo(),
            "TituloP deve gerar debito");
        TesteUtil.verificar(!titulo.Pagamento(19, "98765-4"),
            "Segundo pagamento deveria falhar");

        System.out.println("FASE 2 APROVADA - Classe TituloP implementada corretamente.");
    }
}
