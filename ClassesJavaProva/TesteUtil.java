public final class TesteUtil {
    private TesteUtil() {
    }

    public static void verificar(boolean condicao, String mensagem) {
        if (!condicao) {
            throw new AssertionError(mensagem);
        }
    }

    public static void verificarIgual(Object esperado, Object obtido,
                                      String mensagem) {
        if (esperado == null ? obtido != null : !esperado.equals(obtido)) {
            throw new AssertionError(mensagem + " | Esperado: " + esperado
                + " | Obtido: " + obtido);
        }
    }

    public static void verificarDouble(double esperado, double obtido,
                                       String mensagem) {
        if (Math.abs(esperado - obtido) > 0.000001) {
            throw new AssertionError(mensagem + " | Esperado: " + esperado
                + " | Obtido: " + obtido);
        }
    }
}
