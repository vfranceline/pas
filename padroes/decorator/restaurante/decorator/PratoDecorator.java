package decorator;

public abstract class PratoDecorator implements PratoRU {
    protected final PratoRU pratoDecorado;

    protected PratoDecorator(PratoRU prato) {
        this.pratoDecorado = prato;
    }

    @Override
    public void montarPrato() {
        pratoDecorado.montarPrato();
    }
}
