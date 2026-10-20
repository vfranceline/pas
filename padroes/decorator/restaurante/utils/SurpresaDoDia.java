package utils;

import java.util.Random;

public class SurpresaDoDia {
    private static final String[] SURPRESINHAS = {
        "Com uma little baratinha",
        "Com um fio de cabelo misterioso de brinde",
        "Com um cheiro meio esquisito..",
        "Com sabor de desespero acadêmico"
    };

    private static final Random random = new Random();

    public static String sortear() {
        if (random.nextDouble() < 0.4) { 
            int index = random.nextInt(SURPRESINHAS.length);
            return SURPRESINHAS[index];
        }
        return "Tudo surpreendentemente normal"; 
    }
} 
