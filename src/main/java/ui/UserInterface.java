package ui;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UserInterface {
    private static final String PROMPT = "Enter text: ";
    private static final String OUTPUT_PREFIX = "Number of words: ";

    private PrintStream uiPrinter;

    public UserInterface(PrintStream uiPrinter) {
        this.uiPrinter = uiPrinter;
    }

    public void printResult(int wordCount) {
        System.out.println(OUTPUT_PREFIX.concat(String.valueOf(wordCount)));
    }

    public String getUserInput(Scanner userInput) {
        return userInput.nextLine();
    }

    public void initialiseUserInterface() {
        uiPrinter.print(PROMPT);
    }

    public Scanner initialiseInputScanner() {
        return new Scanner(System.in);
    }
}
