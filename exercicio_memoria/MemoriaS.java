public abstract class MemoriaS{
    // constantes
    public static final int BYTE = 1;
    public static final int KB = 1024;
    public static final int MB = KB*1024;
    public static final int GB = MB*1024;

    // atributos
    public double total;
    public double utilizadoKB;
    public int unidade = BYTE;

    public MemoriaS(int newTotal, int newUnidade){
        this.total = newTotal;
        this.utilizadoKB = 0.0;
        this.unidade = newUnidade;
    }

    public MemoriaS(int newTotal){
        this(newTotal, KB);
    }

    public abstract double getPerda();

    public abstract double getEspacoDisponivelRealKB();

    public double getEspacoDisponivelKB(){
        return (this.total)-(this.utilizadoKB);
    }

    public boolean GravaKB(int newTamanho){
        if (this.getEspacoDisponivelRealKB() >= newTamanho){
            this.utilizadoKB = this.utilizadoKB + newTamanho;
            return true;
        } else{
            return false;
        }
    }

    public double getConverteKB(double valor){
        return valor/unidade;
    }

    public String getUnidade(){
        return switch (this.unidade) {
            case BYTE -> "BYTE"; 
            case KB -> "KB";
            case MB -> "MB";
            case GB -> "GB";
            default -> null;
        };
    }

    public double getPercentualDisponivel(){
        return this.getEspacoDisponivelRealKB()/(this.total*100);
    }

    @Override
    public String toString() {
        return "Percentual Disponível: " + this.getPercentualDisponivel() + "%" +
               "\nEspaço Total: " + this.total + "KB" +
               "\nEspaço Disponível Real: " + this.getEspacoDisponivelRealKB() + "KB" +
               "\nPerda: " + this.getPerda() + "%";
    }
}