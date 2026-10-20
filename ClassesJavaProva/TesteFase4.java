public class TesteFase4 {
    public static void main(String[] args) {
        Titulo noPrazo = new TituloR(
            "Venda no prazo", 1000.00, 20, "Cliente A", 0.10
        );
        Titulo vencido = new TituloR(
            "Venda vencida", 1000.00, 20, "Cliente B", 0.10
        );
        Titulo aPagar = new TituloP(
            "Pagamento de fornecedor", 400.00, 20, "Fornecedor C"
        );

        TesteUtil.verificar(noPrazo.Pagamento(20, "11111-1"),
            "Pagamento no prazo deveria ser realizado");
        TesteUtil.verificarDouble(1000.00, noPrazo.getBancario().getValor(),
            "Pagamento no prazo nao deve receber juros");
        TesteUtil.verificarIgual("Credito", noPrazo.getBancario().getTipo(),
            "TituloR deve gerar credito");
        TesteUtil.verificar(vencido.Pagamento(25, "22222-2"),
            "Pagamento vencido deveria ser realizado");
        TesteUtil.verificarDouble(1100.00, vencido.getBancario().getValor(),
            "Correcao com juros incorreta");
        TesteUtil.verificar(!vencido.Pagamento(26, "22222-2"),
            "Segundo pagamento deveria falhar");
        TesteUtil.verificar(aPagar.Pagamento(20, "33333-3"),
            "TituloP deveria ser pago polimorficamente");
        TesteUtil.verificarIgual("Debito", aPagar.getBancario().getTipo(),
            "TituloP deve gerar debito");

        System.out.println("FASE 4 APROVADA - Pagamento, juros e polimorfismo validados.");
    }
}
