package guilda.filtro;

import guilda.decorator.Heroi;
import java.util.List;

/**
 * SOLUÇÃO: o herói precisa atender aos DOIS critérios (A e B).
 * Pense: dá para encadear um filtro no resultado do outro?
 */
public class CriterioE implements Criterio {
    private final Criterio a;
    private final Criterio b;

    public CriterioE(Criterio a, Criterio b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public List<Heroi> filtrar(List<Heroi> herois) {
        List<Heroi> primeiraFiltragem = a.filtrar(herois);
        return b.filtrar(primeiraFiltragem);
    }
}
