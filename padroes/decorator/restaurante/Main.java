
import decorator.*;
import observer.*;

public class Main {
    public static void main(String[] args) {

        //Criação da cuba
        CubaAlimento cubaArroz = new CubaAlimento("Arroz");
        CubaAlimento cubaFeijao = new CubaAlimento("Feijão");

        //Criação do Funcionário
        FuncionarioCozinha carlinhos = new FuncionarioCozinha("Carlinhos Maia");
        FuncionarioCozinha virginia = new FuncionarioCozinha("Virginia Fonseca");

        //Fazendo com que este funcionário fique de olho nessa cuba
        cubaArroz.adicionarObservador(carlinhos); 
        cubaFeijao.adicionarObservador(virginia);

        //Prato do Aluno 1
        PratoRU bandejaAluno1 = new Bandeja(); 
        bandejaAluno1 = new Arroz(bandejaAluno1, cubaArroz); 
        bandejaAluno1.montarPrato();

        //Prato do Aluno 2 em pipeline: bandeja -> arroz -> feijão -> suco
        PratoRU bandejaAluno2 = new Suco(
                new Feijao(
                        new Arroz(new Bandeja(), cubaArroz),
                        cubaFeijao));
        bandejaAluno2.montarPrato();
    }
}