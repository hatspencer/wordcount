package userinput;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleInputReader implements UserInputReader {

    private Scanner scanner;

    public ConsoleInputReader(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public String readUserInput() {
        printWelcomeMessage();
        return scanner.nextLine();
    }

    private void printWelcomeMessage() {
        String welcomeText = "Enter text: ";
        System.out.print(welcomeText);
    }
}
