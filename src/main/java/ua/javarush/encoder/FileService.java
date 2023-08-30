package ua.javarush.encoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    private final String PATH_SOURS;
    private final Command COMMAND;

    FileService(String path, Command command) {
        PATH_SOURS = path;
        COMMAND = command;
    }

    public void createAndEncryptDecryptFile(int key){

        String pathResultFile = PATH_SOURS.substring(0, PATH_SOURS.lastIndexOf('.')) + "[" + COMMAND + "ED" + "]" + ".txt";

        try {
            Path resultFile = Files.createFile(Path.of(pathResultFile));
        }catch (IOException e){
            System.out.println("Failed to create file, error:  " + e);
        }

        switch (COMMAND){
            case ENCRYPT:
                fileReadEncryptWrite(pathResultFile, key);
                break;

            case DECRYPT:
                fileReadDecryptWrite(pathResultFile, key);
                break;
        }


    }

    private void fileReadEncryptWrite(String pathResultFile, int key){

        CaesarCipher caesarCipher = new CaesarCipher(key);

        try (FileReader fileReader = new FileReader(PATH_SOURS);
             BufferedReader buffer = new BufferedReader(fileReader);
             FileWriter writer = new FileWriter(pathResultFile)) {

            while (buffer.ready()) {

                char symbol = (char) buffer.read();
                writer.write(caesarCipher.encrypt(symbol));

            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void fileReadDecryptWrite(String pathResultFile, int key){

        CaesarCipher caesarCipher = new CaesarCipher(key);

        try (FileReader fileReader = new FileReader(PATH_SOURS);
             BufferedReader buffer = new BufferedReader(fileReader);
             FileWriter writer = new FileWriter(pathResultFile)) {

            while (buffer.ready()) {

                char symbol = (char) buffer.read();
                writer.write(caesarCipher.decrypt(symbol));

            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
