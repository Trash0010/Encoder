package ua.javarush.encoder;

import java.nio.file.Path;

public class CaesarCipher {
    private char[] LETTERS_UPPERCASE;
    private char[] LETTERS_LOWERCASE;
    private final int KEY;

    CaesarCipher(int key) {
        KEY = key;
        Language language = new Language();
        LETTERS_UPPERCASE = language.ENGLISH_UPPERCASE;
        LETTERS_LOWERCASE = language.ENGLISH_LOWERCASE;
    }

    public Character encrypt(Path path, Character symbol) {
        for (int i = 0; i < LETTERS_UPPERCASE.length; i++) {

            int indexOfNewSymbol = i + KEY;

            if (LETTERS_UPPERCASE[i] == symbol) {

                if (indexOfNewSymbol > LETTERS_UPPERCASE.length - 1) {
                    indexOfNewSymbol -= LETTERS_UPPERCASE.length;
                }
                symbol = LETTERS_UPPERCASE[indexOfNewSymbol];
                return symbol;

            } else if (LETTERS_LOWERCASE[i] == symbol) {

                if (indexOfNewSymbol > LETTERS_LOWERCASE.length - 1) {
                    indexOfNewSymbol -= LETTERS_LOWERCASE.length;
                }
                symbol = LETTERS_LOWERCASE[indexOfNewSymbol];
                return symbol;
            }
        }

        return symbol;
    }


}
