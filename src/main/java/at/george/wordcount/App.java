package at.george.wordcount;

import java.util.Objects;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        final WordCounter wordCounter = new WordCounter();
        boolean hasCommandLineOneArgument = Objects.nonNull(args) && args.length == 1;
        if (hasCommandLineOneArgument) {
            final int count = wordCounter.countFromFile(args[0]);
            System.out.println("Number of words: " + count);
            return;
        }

        System.out.print("Enter text: ");
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();

        if (Objects.isNull(input)) {
            System.out.println("Number of words: 0");
            return;
        }

        final int count = wordCounter.count(input);
        System.out.println("Number of words: " + count);
    }
}
