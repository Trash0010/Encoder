package ua.javarush.encoder;

public class Language {
    public final char[] ENGLISH_UPPERCASE;
    public final char[] ENGLISH_LOWERCASE;

    Language() {

        //The interval of English letters in Uppercase is 65 - 90

        char[] symbolsUpper = new char[26];

        for (int i = 0; i < 26; i++) {
            symbolsUpper[i] = (char) (i + 65);
        }
        ENGLISH_UPPERCASE = symbolsUpper;


        //The interval of English letters in Lowercase is 97 - 122

        char[] symbolsLower = new char[26];

        for (int i = 0; i < 26; i++) {
            symbolsUpper[i] = (char) (i + 97);
        }
        ENGLISH_LOWERCASE = symbolsLower;

    }
}
