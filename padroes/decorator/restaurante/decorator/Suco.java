package decorator;

public class Suco extends PratoDecorator {
    public Suco(PratoRU prato) {
        super(prato);
    }

    @Override
    public void montarPrato() {

        super.montarPrato();

        System.out.println("\n-> Pegou um Copo de Suco gelado.");
    }
}
