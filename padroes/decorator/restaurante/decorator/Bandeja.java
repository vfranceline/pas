package decorator;

//Implementação Concreta, todo PratoRU implementado deve ter como base a bandeja.
public class Bandeja implements PratoRU {
    @Override
    public void montarPrato() {
        System.out.println("\nBandeja vazia pega na entrada.");
    }
}
