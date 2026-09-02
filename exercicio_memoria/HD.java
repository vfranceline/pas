public class HD extends MemoriaS{
    private String numeroSerie;

    public HD(String numeroSerie, int newTotal, int newUnidade) {
        super(newTotal, newUnidade);
        this.numeroSerie = numeroSerie;
    }

    @Override
    public double getPerda(){
        return (this.total/10240)/100;
    }
    
    @Override
    public double getEspacoDisponivelRealKB(){
        return this.getEspacoDisponivelKB()*(1-getPerda());
    }

    public String getNumeroSerie(){
        return this.numeroSerie;
    }

    @Override
    public String toString() {
        return String.format("HD Número de Serie %s %nPercentual Disponível %f " +
                               "%nEspaço Total %f KB" +
                               "%nEspaço Disponível Real %f KB " +
                               "%nPerda %f %%",
                               this.numeroSerie, this.getPercentualDisponivel(), this.total, this.getEspacoDisponivelRealKB(), this.getPerda());
    }
}
