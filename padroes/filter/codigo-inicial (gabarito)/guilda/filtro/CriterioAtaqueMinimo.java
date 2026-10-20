package guilda.filtro;

import guilda.decorator.Heroi;
import java.util.ArrayList;
import java.util.List;

/** SOLUÇÃO: mantém heróis com ataque total >= minimo. */
public class CriterioAtaqueMinimo implements Criterio {
    private final int minimo;

    public CriterioAtaqueMinimo(int minimo) {
        this.minimo = minimo;
    }

    @Override
    public List<Heroi> filtrar(List<Heroi> herois) {
        List<Heroi> resultado = new ArrayList<>();
        for (Heroi h : herois) {
            if (h.getAtaque() >= minimo) {
                resultado.add(h);
            }
        }
        return resultado;
    }
}
