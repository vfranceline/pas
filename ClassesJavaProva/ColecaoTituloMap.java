
import java.util.*;

public class ColecaoTituloMap {

    private HashMap<String, Titulo> titulos;

    public ColecaoTituloMap(){
        this.titulos = new HashMap<String, Titulo>();
    }

    public boolean adicionaTitulo(Titulo titulo){
        if (titulo == null){
            return false;
        }

        boolean hasTitulo = titulos.containsKey(titulo.getDescricao());

        if (hasTitulo){
            return false;
        } else {
            titulos.put(titulo.getDescricao(), titulo);
            return true;
        }

    }

    public double balanco(){
        // soma o valor dos objetos TituloR e subtrai o valor dos objetos TituloP.
        // Percorra titulos.values().iterator() com Iterator<Titulo> no cálculo do balanço
        Iterator<Titulo> it = this.titulos.values().iterator();
        double valor = 0;

        while(it.hasNext()){
            Titulo t = it.next();
            
            if (t instanceof TituloR){
                valor += t.getValor();
            } else if (t instanceof TituloP){
                valor -= t.getValor();
            }
        }
        return valor;
    }

    public Collection<Titulo> getTitulos(){
        // retorna Collection<Titulo> contendo uma cópia dos títulos armazenados
        return titulos.values();

    }
}
