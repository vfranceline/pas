package exercicio;

// Comando concreto: liga a lampada.
// Pense: qual e o "contrario" de ligar?

public class ComandoLigarLampada implements Comando {
    private final Lampada lampada;

    public ComandoLigarLampada(Lampada lampada) {
        this.lampada = lampada;
    }

    @Override
    public void executar() {
        lampada.ligar();
    }

    @Override
    public void desfazer() {
        lampada.desligar();
    }
}
