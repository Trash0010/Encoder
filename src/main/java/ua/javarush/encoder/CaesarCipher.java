package ua.javarush.encoder;

import java.nio.file.Path;

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

    // TODO: 24.08.2023  створити окремий метод для розрахунку переповненого ключа (строка 27, 35)

    public Character encrypt(Character symbol) {
        for (int i = 0; i < LETTERS_UPPERCASE.length; i++) {

            int indexOfNewSymbol = i + KEY;

            if (LETTERS_UPPERCASE[i] == symbol) {

                if (indexOfNewSymbol > LETTERS_UPPERCASE.length - 1) {
                    indexOfNewSymbol = indexOfNewSymbol - ((indexOfNewSymbol / LETTERS_UPPERCASE.length) * LETTERS_UPPERCASE.length);
                }
                symbol = LETTERS_UPPERCASE[indexOfNewSymbol];
                return symbol;

            } else if (LETTERS_LOWERCASE[i] == symbol) {

                if (indexOfNewSymbol > LETTERS_LOWERCASE.length - 1) {
                    indexOfNewSymbol = indexOfNewSymbol - ((indexOfNewSymbol / LETTERS_LOWERCASE.length) * LETTERS_LOWERCASE.length);
                }
                symbol = LETTERS_LOWERCASE[indexOfNewSymbol];
                return symbol;
            }
        }

        return symbol;
    }

    public Character decrypt(Character symbol) {
        for (int i = 0; i < LETTERS_UPPERCASE.length; i++) {
            if (LETTERS_UPPERCASE[i] == symbol) {
                int indexNewChar = i - KEY;

                if (indexNewChar < 0) {
                    int sumOfCycles = KEY / LETTERS_UPPERCASE.length;

                    indexNewChar = i - (KEY - (LETTERS_UPPERCASE.length * sumOfCycles));

                    if (indexNewChar < 0) {
                        indexNewChar = LETTERS_UPPERCASE.length - Math.abs(indexNewChar);
                    }

                }

                symbol = LETTERS_UPPERCASE[indexNewChar];
                return symbol;

            } else if (LETTERS_LOWERCASE[i] == symbol) {
                int indexNewChar = i - KEY;

                if (indexNewChar < 0) {
                    int sumOfCycles = KEY / LETTERS_LOWERCASE.length;

                    indexNewChar = i - (KEY - (LETTERS_LOWERCASE.length * sumOfCycles));

                    if (indexNewChar < 0) {
                        indexNewChar = LETTERS_LOWERCASE.length - Math.abs(indexNewChar);
                    }

                }

                symbol = LETTERS_LOWERCASE[indexNewChar];
                return symbol;
            }
        }

        return symbol;
    }
}