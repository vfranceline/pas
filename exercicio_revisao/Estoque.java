package exercicio_revisao;

public class Estoque {

    private Produto produto;
    private Fornecedor fornecedor;
    private int quantidade;

    public Estoque() {
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        // O critério de igualdade é se tiver o mesmo código do produto e o mesmo código do fornecedor
        Estoque outro = (Estoque) o;
        return (outro.getProduto().getCodigo()).equals(this.produto.getCodigo())
                && (outro.getFornecedor().getCodigo()).equals(this.fornecedor.getCodigo());
    }
}
