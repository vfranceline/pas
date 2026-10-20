package exercicio_revisao;

import java.util.*;

public class Compras {

    private Map cProduto = new HashMap();
    private Map cFornecedor = new HashMap();
    private List cEstoque = new ArrayList();

    public Compras() {
    }

    public boolean adicionaProduto(Produto p) {
        boolean hasProduto = cProduto.containsKey(p.getCodigo());
        if (hasProduto) {
            return false;
        } else {
            cProduto.put(p.getCodigo(), p);
            return true;
        }
    }

    public boolean adicionaFornecedor(Fornecedor f) {
        boolean hasFornecedor = cFornecedor.containsKey(f.getCodigo());
        if (hasFornecedor) {
            return false;
        } else {
            cFornecedor.put(f.getCodigo(), f);
            return true;
        }
    }

    public void compra(String codigoProduto, String codigoFornecedor, int qtd) {
        Produto p = (Produto) this.cProduto.get(codigoProduto);
        Fornecedor f = (Fornecedor) this.cFornecedor.get(codigoFornecedor);
        Estoque e = new Estoque();
        e.setFornecedor(f);
        e.setProduto(p);

        if (this.cEstoque.contains(e)) {
            // Caso II: O estoque já existe
            // Localize o estoque, recupera da lista e incrementa a quantidade
            int index = this.cEstoque.indexOf(e);
            Estoque estoq = (Estoque) this.cEstoque.get(index);
            estoq.setQuantidade(estoq.getQuantidade() + qtd);

        } else {
            // Caso I: O estoque não existe
            // Este método deve criar um estoque definindo o seu produto, fornecedor (localizar produtos e
            // fornecedores já cadastrados) e quantidade. Por fim, adicione o estoque na lista.
            e.setQuantidade(qtd);
            this.cEstoque.add(e);
        }

    }

    public int quantidadeDeProduto(String codigoProdto) {
        Iterator iterator = this.cEstoque.iterator();

        int qnt = 0;

        while(iterator.hasNext()){
            Estoque estoque = (Estoque) iterator.next();
            if (estoque.getProduto().getCodigo().equals(codigoProdto)){
                qnt += estoque.getQuantidade();
            }
        }
        return qnt;
    }

    // Lista os produtos vinculados com o preço*quantidade no estoque
    public String totalPorProduto() {
        StringBuilder texto = new StringBuilder();
        texto.append("Total Produto \n");

        Iterator iterator = this.cProduto.values().iterator();

        while (iterator.hasNext()) {
            Produto p = (Produto) iterator.next();
            texto.append("Produto: ").append(p.getDescricao()).append("\n");

            double total = 0;
            for (int j = 0; j < cEstoque.size(); j++) {
                Estoque e = (Estoque) cEstoque.get(j);
                if (e.getProduto().getCodigo().equals(p.getCodigo())) {
                    total += e.getProduto().getPreco() * e.getQuantidade();
                }
            }
            texto.append("Total: ").append(total).append("\n");
        }

        return texto.toString();
    }

    public String fornecedorProdutos() {
        StringBuilder texto = new StringBuilder();
        texto.append("Lista de Fornecedores e seus produtos\n");

        Iterator iterator = this.cFornecedor.values().iterator();

        while (iterator.hasNext()) {
            Fornecedor f = (Fornecedor) iterator.next();
            texto.append("Fornecedor: ").append(f.getDescricao()).append("\n");

            for (int j = 0; j < cEstoque.size(); j++) {
                Estoque e = (Estoque) cEstoque.get(j);
                if (e.getFornecedor().getCodigo().equals(f.getCodigo())) {
                    texto.append("Produto: ").append(e.getProduto().getDescricao()).append("\n");
                }
            }
        }

        return texto.toString();
    }

    public static void main(String args[]) {
        Compras c = new Compras();
        Produto[] p = new Produto[3];
        p[0] = new Produto();
        p[0].setCodigo("P-1");
        p[0].setDescricao("CD");
        p[0].setPreco(1.20);
        c.adicionaProduto(p[0]);
        p[1] = new Produto();
        p[1].setCodigo("P-30");
        p[1].setDescricao("Papel");
        p[1].setPreco(15);
        c.adicionaProduto(p[1]);
        p[2] = new Produto();
        p[2].setCodigo("P-3");
        p[2].setDescricao("Cola");
        p[2].setPreco(3.25);
        c.adicionaProduto(p[2]);
        Fornecedor[] f = new Fornecedor[2];
        f[0] = new Fornecedor();
        f[0].setCodigo("F-1");
        f[0].setDescricao("Empresa XO");
        c.adicionaFornecedor(f[0]);
        f[1] = new Fornecedor();
        f[1].setCodigo("F-2");
        f[1].setDescricao("Empresa ABC");
        c.adicionaFornecedor(f[1]);
        c.compra("P-3", "F-1", 10);
        c.compra("P-3", "F-1", 20);
        c.compra("P-30", "F-1", 5);
        c.compra("P-30", "F-1", 50);
        c.compra("P-1", "F-1", 20);
        c.compra("P-1", "F-2", 30);
        System.out.println(c.quantidadeDeProduto("P-30"));
        System.out.println(c.totalPorProduto());
        System.out.println(c.fornecedorProdutos());
    }

}
