import java.util.*;
// import  Titulo;

public class ColecaoTituloList{
    private ArrayList<Titulo> titulos;

    public ColecaoTituloList(){
        titulos = new ArrayList<>();
    }

    public boolean adicionaTitulo(Titulo titulo){
        if(titulos.contains(titulo) || titulos.equals(titulo) || titulo == null){
            return false;
        }
        else{
            return titulos.add(titulo);
        }
    }


    public double balanco(){
        double valorBalanco = 0;

        Iterator<Titulo> iterator = titulos.iterator();
        while(iterator.hasNext()){
            Titulo titulo = iterator.next();
            if(titulo instanceof TituloR){
                valorBalanco += titulo.getValor();
            }else if(titulo instanceof TituloP){
                valorBalanco -= titulo.getValor();
            }
        }

        return valorBalanco;
    }

    public Collection<Titulo> getTitulos(){
        return titulos;
    }

}