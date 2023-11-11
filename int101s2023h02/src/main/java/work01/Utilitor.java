package work01;

public class Utilitor {

    public static String testString(String value) {
        if (value == null) {
            throw new NullPointerException();
        }
        if (value.isBlank()) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    public static double testPositive(double value) {
        if (value > 0) {
            return value;
        }
        throw new IllegalArgumentException();
    }

    public static long computeIsbn10(long isbn10) {
        long tempisbn = isbn10;
        long digit = 1;
        long check = 0;
        long tempo;
        while (tempisbn > 0) {
            tempo = tempisbn % 10;
            check += digit * tempo;
            digit++;
            tempisbn /= 10;
        }
        tempo = isbn10 % 10;
        if (tempo == 1) {
            check = 1;
        }
        if (tempo != 1) {
        check -= tempo;
        }
        if (check % 11 != 0) {
            if (check % 11 == 1) {
                return isbn10 + 1000000000;
            }
            tempisbn = isbn10 / 10;
            check = 11 - (check % 11);
            return tempisbn * 10 + check;
        } else {
            return isbn10;
        }
    }

}
