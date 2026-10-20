package observer;

import java.util.ArrayList;
import java.util.List;

import utils.SurpresaDoDia;

public class CubaAlimento {
    private final String nomeItem;
    private int porcoesRestantes;
    private final List<Observador> funcionarios = new ArrayList<>();
    private boolean alertaEnviado;

    public CubaAlimento(String nomeItem) {
        this.nomeItem = nomeItem;
        this.porcoesRestantes = 3;
    }

    public void adicionarObservador(Observador observador) {
        if (observador != null) {
            funcionarios.add(observador);
        }
    }

    // Método que vai decidir se notifica os funcionários ou não com base na quantidade de porções restantes.
    // A cada vez que é chamado
    public void servirPorcao() {
        System.out.println("\nDentro da cozinha\n ===");
        if (porcoesRestantes <= 0) {
            System.out.println("Não há mais porções de "+ this.nomeItem + "===\n");
            return;
        }

        System.out.println("Porção de " + this.nomeItem + " servida. " + SurpresaDoDia.sortear());
        porcoesRestantes--;
        if (porcoesRestantes <= 2 && !alertaEnviado) {
            alertaEnviado = true;

            notificarFuncionarios("ALERTA: A cuba de " + nomeItem + " está acabando! Repor.");
        }
        System.out.println(" ===");
    }

    private void notificarFuncionarios(String mensagem) {
        for (Observador observador : funcionarios) {
            observador.atualizar(mensagem);
        }
    }
}
