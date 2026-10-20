package guilda.filtro;

import guilda.decorator.Heroi;
import java.util.ArrayList;
import java.util.List;

/** PARTE 1 - TODO: mantém heróis com ataque total >= minimo. */
public class CriterioAtaqueMinimo implements Criterio {
    private final int minimo;

    public CriterioAtaqueMinimo(int minimo) {
        this.minimo = minimo;
    }

    @Override
    public List<Heroi> filtrar(List<Heroi> herois) {
        // TODO
        return new ArrayList<>();
    }
}
