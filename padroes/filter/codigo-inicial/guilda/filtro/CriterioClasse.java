package guilda.filtro;

import guilda.decorator.Heroi;
import java.util.ArrayList;
import java.util.List;

/** PARTE 1 - TODO: mantém apenas heróis da classe informada (ex.: "Guerreiro"). */
public class CriterioClasse implements Criterio {
    private final String classe;

    public CriterioClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public List<Heroi> filtrar(List<Heroi> herois) {
        // TODO
        return new ArrayList<>();
    }
}
