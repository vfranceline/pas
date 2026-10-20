public class Bancario {
    public static final int DEBITO = 0;
    public static final int CREDITO = 1;

    private String conta;
    private double valor;
    private int tipo;

    public Bancario(String newConta, double newValor, int newTipo) {
        this.conta = newConta;
        this.valor = newValor;
        this.tipo = newTipo;
    }

    public String getConta() {
        return this.conta;
    }

    public double getValor() {
        return this.valor;
    }

    public int getCodigoTipo() {
        return this.tipo;
    }

    public String getTipo() {
        return this.tipo == Bancario.CREDITO ? "Credito" : "Debito";
    }

    @Override
    public String toString() {
        return "Lancamento Bancario - Conta: " + this.conta
            + " Valor: " + this.valor + " Tipo: " + this.getTipo();
    }
}
