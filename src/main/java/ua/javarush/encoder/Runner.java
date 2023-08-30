package ua.javarush.encoder;

public class Runner {
    public static void start(String[] args) {
        if (args.length != 0) {

            Command command = Command.valueOf(args[0]);

            switch (command) {
                case DECRYPT, ENCRYPT:
                    String path = args[1];
                    int key = Integer.parseInt(args[2]);
                    FileService fileService = new FileService(path, command);
                    fileService.createAndEncryptDecryptFile(key);
                    break;
                case BRUTE_FORCE:
                    System.out.println("BRUTE_FORCE not implemented");
                default:
                    System.out.println("Invalid command, please try again.");
                    System.out.println("List of available commands: ENCRYPT, DECRYPT, BRUTE_FORCE");
            }

        } else {
            ClientConsole clientConsole = new ClientConsole();
            clientConsole.addParameters();
        }

    }
}
