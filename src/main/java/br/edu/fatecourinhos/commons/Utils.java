package br.edu.fatecourinhos.commons;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Utils {
    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lower = upper.toLowerCase(Locale.ROOT);
    private static final String digits = "0123456789";
    private static final String alphanum = upper + lower + digits;
    private static final Random random = new SecureRandom();
    private static final char[] symbols = alphanum.toCharArray();

    public static String nextString(int length) {
        if (length < 1) throw new IllegalArgumentException();
        char[] buf = new char[length];
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    public static String getElapsedTimeMessage(long elapsedTime) {
        return elapsedTime + " nanoSec -> " + TimeUnit.NANOSECONDS.toMillis(elapsedTime) + " ms. ";
    }

    public static String getObjectFoundMessage(boolean l) {
        return l ? "Valor encontrado" : "Valor não encontrado";
    }
}
