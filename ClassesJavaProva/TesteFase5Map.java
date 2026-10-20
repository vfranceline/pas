public class TesteFase5Map {
    public static void main(String[] args) {
        ColecaoTituloMap colecao = new ColecaoTituloMap();
        executarTestes(colecao);
        System.out.println("FASE 5 MAP APROVADA - HashMap, chave unica, Iterator e balanco validados.");
        System.out.println("TODAS AS FASES FORAM CONCLUIDAS COM SUCESSO.");
    }

    private static void executarTestes(ColecaoTituloMap colecao) {
        Titulo receber1 = new TituloR("Venda A", 1000.00, 20, "Cliente A", 0.01);
        Titulo receber2 = new TituloR("Venda B", 500.00, 25, "Cliente B", 0.01);
        Titulo pagar = new TituloP("Conta de energia", 300.00, 22, "Fornecedor C");
        Titulo repetido = new TituloP("Venda A", 9000.00, 30, "Outro fornecedor");

        TesteUtil.verificar(colecao.adicionaTitulo(receber1), "Primeiro titulo deveria ser adicionado");
        TesteUtil.verificar(colecao.adicionaTitulo(receber2), "Segundo titulo deveria ser adicionado");
        TesteUtil.verificar(colecao.adicionaTitulo(pagar), "Titulo a pagar deveria ser adicionado");
        TesteUtil.verificar(!colecao.adicionaTitulo(repetido), "Chave de descricao repetida nao pode ser adicionada");
        TesteUtil.verificar(!colecao.adicionaTitulo(null), "Valor nulo nao pode ser adicionado");
        TesteUtil.verificarIgual(3, colecao.getTitulos().size(), "Quantidade de titulos incorreta");
        TesteUtil.verificarDouble(1200.00, colecao.balanco(), "Balanco do mapa incorreto");
    }
}
