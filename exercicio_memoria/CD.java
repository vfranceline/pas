public class CD extends MemoriaS {

    public static final int FECHADO = 1;
    public static final int ABERTO = 0;

    protected int estado;

    public CD(int newTotal, int newUnidade) {
        super(newTotal, newUnidade);
    }

    @Override
    public double getPerda() {
        return 0.98;
    }

    @Override
    public double getEspacoDisponivelRealKB() {
        return getEspacoDisponivelKB() * (1 - (getPerda() / 100));

    }

    @Override
    public boolean GravaKB(int newTamanho) {
        if (estado == ABERTO) {
            this.estado = FECHADO;
            return super.GravaKB(newTamanho);
        } else {
            System.out.println("CD Fechado");
            return false;
        }
    }

    public String getEstado() {
        return estado == ABERTO ? "ABERTO" : "FECHADO";
    }

    @Override
    public String toString() {
        return "CD Estado: " + getEstado() + " Percentual Disponível: " + getPercentualDisponivel() + "% Espaço Total: "
                + this.total + "KB Espaço Disponível Real: " + getEspacoDisponivelRealKB() + "KB Perda: " + getPerda()
                + "%";
    }

}