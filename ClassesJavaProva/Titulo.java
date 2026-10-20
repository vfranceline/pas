public abstract class Titulo {

    public static final int ABERTO = 0;
    public static final int CANCELADO = 1;
    public static final int QUITADO = 2;
    protected int estado;
    protected String descricao;
    protected double valor;
    protected int dataVencimento;
    protected Bancario bancario;

    public Titulo(String newDescricao, double newValor, int newDataVencimento) {
        this.descricao = newDescricao;
        this.valor = newValor;
        this.dataVencimento = newDataVencimento;
        this.estado = ABERTO;

    }

    public abstract boolean Pagamento(int dataAtual, String newConta);

    public boolean Vencido(int dataAtual) {
        return (dataAtual > this.dataVencimento);
    }

    public boolean Cancela(int dataAtual) {
        boolean isCancelado = this.estado == ABERTO && !this.Vencido(dataAtual);

        if (isCancelado) {
            this.estado = CANCELADO;
        }
        return isCancelado;
    }

    public Bancario getBancario() {
        return bancario;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEstado() {
        String estadoString = "";
        if (estado == ABERTO) {
            estadoString = "Aberto";
        } else if (estado == CANCELADO) {
            estadoString = "Cancelado";
        } else if (estado == QUITADO) {
            estadoString = "Quitado";
        }
        return estadoString;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Estado: " + this.getEstado()
                + "Descrição: " + this.descricao
                + "Valor: " + this.valor 
                + "Data de Vencimento: " + this.dataVencimento
                + this.bancario.toString();
    }

    @Override 
    public boolean equals(Object objeto){
        Titulo t = (Titulo) objeto;

        return this.descricao.equals(t.getDescricao());
    }
}
