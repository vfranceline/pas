public class TesteFase5List {
    public static void main(String[] args) {
        ColecaoTituloList colecao = new ColecaoTituloList();
        executarTestes(colecao);
        System.out.println("FASE 5 LIST APROVADA - ArrayList, unicidade, Iterator e balanco validados.");
    }

    private static void executarTestes(ColecaoTituloList colecao) {
        Titulo receber1 = new TituloR("Venda A", 1000.00, 20, "Cliente A", 0.01);
        Titulo receber2 = new TituloR("Venda B", 500.00, 25, "Cliente B", 0.01);
        Titulo pagar = new TituloP("Conta de energia", 300.00, 22, "Fornecedor C");
        Titulo repetido = new TituloP("Venda A", 9000.00, 30, "Outro fornecedor");

        TesteUtil.verificar(colecao.adicionaTitulo(receber1), "Primeiro titulo deveria ser adicionado");
        TesteUtil.verificar(colecao.adicionaTitulo(receber2), "Segundo titulo deveria ser adicionado");
        TesteUtil.verificar(colecao.adicionaTitulo(pagar), "Titulo a pagar deveria ser adicionado");
        TesteUtil.verificar(!colecao.adicionaTitulo(repetido), "Descricao repetida nao pode ser adicionada");
        TesteUtil.verificar(!colecao.adicionaTitulo(null), "Valor nulo nao pode ser adicionado");
        TesteUtil.verificarIgual(3, colecao.getTitulos().size(), "Quantidade de titulos incorreta");
        TesteUtil.verificarDouble(1200.00, colecao.balanco(), "Balanco da lista incorreto");
    }
}
