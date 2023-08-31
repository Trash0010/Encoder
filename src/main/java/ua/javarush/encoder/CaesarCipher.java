package ua.javarush.encoder;

public class CaesarCipher {
    private final char[] LETTERS_UPPERCASE;
    private final char[] LETTERS_LOWERCASE;
    private final int KEY;

    CaesarCipher(int key) {
        KEY = key;
        Language language = new Language();
        LETTERS_UPPERCASE = language.ENGLISH_UPPERCASE;
        LETTERS_LOWERCASE = language.ENGLISH_LOWERCASE;
    }

    public char encrypt(char symbol) {
        for (int i = 0; i < LETTERS_UPPERCASE.length; i++) {

            int indexOfNewSymbol = i + KEY;

            if (LETTERS_UPPERCASE[i] == symbol) {

                if (indexOfNewSymbol > LETTERS_UPPERCASE.length - 1) {

                    indexOfNewSymbol = getTrueKeyForEncrypt(indexOfNewSymbol, LETTERS_UPPERCASE.length);
                }

                symbol = LETTERS_UPPERCASE[indexOfNewSymbol];
                return symbol;

            } else if (LETTERS_LOWERCASE[i] == symbol) {

                if (indexOfNewSymbol > LETTERS_LOWERCASE.length - 1) {

                    indexOfNewSymbol = getTrueKeyForEncrypt(indexOfNewSymbol, LETTERS_LOWERCASE.length);

                }

                symbol = LETTERS_LOWERCASE[indexOfNewSymbol];
                return symbol;
            }
        }

        return symbol;
    }

    public char decrypt(char symbol) {
        for (int i = 0; i < LETTERS_UPPERCASE.length; i++) {
            if (LETTERS_UPPERCASE[i] == symbol) {
                int indexNewChar = i - KEY;

                if (indexNewChar < 0) {

                    indexNewChar = getTrueKeyForDecrypt(i, LETTERS_UPPERCASE.length);

                }

                symbol = LETTERS_UPPERCASE[indexNewChar];
                return symbol;

            } else if (LETTERS_LOWERCASE[i] == symbol) {
                int indexNewChar = i - KEY;

                if (indexNewChar < 0) {

                    indexNewChar = getTrueKeyForDecrypt(i, LETTERS_LOWERCASE.length);


                }

                symbol = LETTERS_LOWERCASE[indexNewChar];
                return symbol;
            }
        }

        return symbol;
    }

    private int getTrueKeyForEncrypt(int overloadKey, int numberOfSymbols) {
        int numberOfCycles = overloadKey / numberOfSymbols;
        int key = overloadKey - (numberOfCycles * numberOfSymbols);
        return key;
    }

    private int getTrueKeyForDecrypt(int indexOfSymbol, int numberOfSymbols) {

        int sumOfCycles = KEY / numberOfSymbols;

        int key = indexOfSymbol - (KEY - (numberOfSymbols * sumOfCycles));

        if (key < 0) {
            key = numberOfSymbols - Math.abs(key);
        }

        return key;
    }
}
