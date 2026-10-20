package guilda.filtro;

import guilda.decorator.Heroi;
import java.util.ArrayList;
import java.util.List;

/**
 * SOLUÇÃO: inverte um critério (fica quem NÃO atende).
 * Atenção: o resultado precisa partir da lista ORIGINAL recebida.
 */
public class CriterioNao implements Criterio {
    private final Criterio criterio;

    public CriterioNao(Criterio criterio) {
        this.criterio = criterio;
    }

    @Override
    public List<Heroi> filtrar(List<Heroi> herois) {
        List<Heroi> atendem = criterio.filtrar(herois);
        List<Heroi> naoAtendem = new ArrayList<>();
        for (Heroi h : herois) {
            if (!atendem.contains(h)) {
                naoAtendem.add(h);
            }
        }
        return naoAtendem;
    }
}
