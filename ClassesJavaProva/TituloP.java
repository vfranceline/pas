public class TituloP extends Titulo{
    private String fornecedor;

    public TituloP(String newDescricao, double newValor, int newDataVencimento, String newFornecedor){
        super(newDescricao, newValor, newDataVencimento);
        this.fornecedor = newFornecedor;
    }

    public String getFornecedor(){
        return this.fornecedor;
    }

    @Override 
    public boolean Pagamento(int dataAtual, String newConta){
        if(this.estado == Titulo.ABERTO && !this.Vencido(dataAtual)){
            Bancario bancario = new Bancario(newConta, this.valor, Bancario.DEBITO);
            super.bancario = bancario;
            this.estado = QUITADO;
            return true;
        }else{
            return  false;
        }
    }

    @Override 
    public String toString(){
        return super.toString() + "Fornecedor: " + this.fornecedor;
    }
}