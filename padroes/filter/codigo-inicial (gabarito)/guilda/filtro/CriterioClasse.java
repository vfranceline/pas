package guilda.filtro;

import guilda.decorator.Heroi;
import java.util.ArrayList;
import java.util.List;

/** SOLUÇÃO: mantém apenas heróis da classe informada (ex.: "Guerreiro"). */
public class CriterioClasse implements Criterio {
    private final String classe;

    public CriterioClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public List<Heroi> filtrar(List<Heroi> herois) {
        List<Heroi> resultado = new ArrayList<>();
        for (Heroi h : herois) {
            if (h.getClasse().equals(classe)) {
                resultado.add(h);
            }
        }
        return resultado;
    }
}
