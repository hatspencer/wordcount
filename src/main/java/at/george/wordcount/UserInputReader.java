package at.george.wordcount;

import java.util.Objects;
import java.util.Scanner;

public class UserInputReader {

//    TODO needs test
    public String readInput() throws  IllegalArgumentException {
        final String input = getUserInput();

        if (Objects.isNull(input)) {
            System.out.println("Number of words: 0");
            throw new IllegalArgumentException("The entered input is empty");
        }
        return input;
    }

    private static String getUserInput() {
        System.out.print("Enter text: ");
        final Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
