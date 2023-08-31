package ua.javarush.encoder;

import java.util.Scanner;

public class ClientConsole {

    public void addParameters(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the operation you want to perform.");
        System.out.println("Available operations: ENCRYPT, DECRYPT, BRUTE_FORCE");
        String clientCommand = scanner.nextLine();

        if(clientCommand.equals("BRUTE_FORCE")){
            System.out.println("Not working yet, choose another operation");
            clientCommand = scanner.nextLine();
        }

        System.out.println("Enter the file path");
        String path = scanner.nextLine();

        System.out.println("Enter the key");
        int key = scanner.nextInt();

        Command command = Command.valueOf(clientCommand);

        switch (command) {
            case DECRYPT, ENCRYPT:

                FileService fileService = new FileService(path, command);
                fileService.createAndEncryptDecryptFile(key);
                break;

            case BRUTE_FORCE:
                System.out.println("BRUTE_FORCE not implemented");
            default:
                System.out.println("Invalid command, please try again.");
                System.out.println("List of available commands: ENCRYPT, DECRYPT, BRUTE_FORCE");
        }

    }
}
