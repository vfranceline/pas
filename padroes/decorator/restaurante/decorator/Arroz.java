package decorator;

import observer.CubaAlimento;

//Elemento que encapsula a bandeja
public class Arroz extends PratoDecorator {
    private final CubaAlimento cubaArroz;

    public Arroz(PratoRU prato, CubaAlimento cubaArroz) {
        super(prato);
        this.cubaArroz = cubaArroz;
    }

    @Override
    public void montarPrato() {

        super.montarPrato();

        System.out.println("\n-> Adicionou Arroz.");

        cubaArroz.servirPorcao();
    }
}
