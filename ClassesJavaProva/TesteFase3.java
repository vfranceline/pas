public class TesteFase3 {
    public static void main(String[] args) {
        TituloR titulo1 = new TituloR(
            "Venda de equipamentos", 2000.00, 30, "Empresa XPTO", 0.02
        );
        TituloR titulo2 = new TituloR(
            "Prestacao de servico", 1000.00, 30, "Cliente ABC"
        );

        TesteUtil.verificarIgual("Empresa XPTO", titulo1.getCliente(),
            "Cliente do primeiro construtor incorreto");
        TesteUtil.verificarDouble(0.02, titulo1.getJuros(),
            "Juros informado nao foi armazenado");
        TesteUtil.verificarIgual("Cliente ABC", titulo2.getCliente(),
            "Cliente do construtor sobrecarregado incorreto");
        TesteUtil.verificarDouble(0.001, titulo2.getJuros(),
            "Taxa-padrao do construtor sobrecarregado incorreta");

        System.out.println("FASE 3 APROVADA - Construtores de TituloR implementados corretamente.");
    }
}
