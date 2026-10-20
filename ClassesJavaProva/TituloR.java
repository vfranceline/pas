public class TituloR extends Titulo{
    private double juros;
    private String cliente;

    public TituloR(String newDescricao, double newValor, int newDataVencimento, String newCliente, double newJuros){
        super(newDescricao, newValor, newDataVencimento);
        this.juros = newJuros;
        this.cliente = newCliente;
    }


    public TituloR(String newDescricao, double newValor, int newDataVencimento, String newCliente){
        this(newDescricao, newValor, newDataVencimento, newCliente, 0.001);
    }

    public double getJuros() {
        return juros;
    }

    public String getCliente() {
        return cliente;
    }

    @Override 
    public boolean Pagamento(int dataAtual, String newConta){
        double valorCalculado = 0;
        if(super.estado == Titulo.ABERTO){
            if(super.Vencido(dataAtual)){
                valorCalculado =  super.valor + (this.valor * this.juros);
            }else{
                valorCalculado = this.valor;
            }

            Bancario bancario = new Bancario(newConta, valorCalculado, Bancario.CREDITO);
            super.bancario = bancario;
            super.estado = Titulo.QUITADO;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "Cliente: " + this.cliente + "Juros: " + this.juros;
    }
}