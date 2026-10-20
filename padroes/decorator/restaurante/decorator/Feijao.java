package decorator;

import observer.CubaAlimento;

public class Feijao extends PratoDecorator {
    private final CubaAlimento cubaFeijao;

    public Feijao(PratoRU prato, CubaAlimento cubaFeijao) {
        super(prato);
        this.cubaFeijao = cubaFeijao;
    }

    @Override
    public void montarPrato() {

        super.montarPrato();

        System.out.println("\n-> Adicionou Concha de Feijão.");

        cubaFeijao.servirPorcao();
    }
}
