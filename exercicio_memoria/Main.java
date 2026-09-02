public class Main {
    public static void main(String[] args) {
        MemoriaS hd = new HD("46327", 10, MemoriaS.MB);
        MemoriaS cd = new CD(650, MemoriaS.MB);

        if (hd instanceof HD h) {
            System.out.println("HD | Número de Série: " + h.getNumeroSerie()
                    + " Percentual de perda: " + h.getPerda() + "%");
        }

        if (cd instanceof CD c) {
            System.out.println("CD | Estado: " + c.getEstado());
        }
    }
}