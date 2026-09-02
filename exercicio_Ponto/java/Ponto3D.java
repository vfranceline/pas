package exercicio_Ponto.java;

public class Ponto3D extends Ponto{
    private int z;

    public Ponto3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}


