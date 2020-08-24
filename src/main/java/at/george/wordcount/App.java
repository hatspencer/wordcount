package at.george.wordcount;

import java.util.Objects;
import java.util.Scanner;

public class App {

    public static final String STOPWORDS_TXT = "stopwords.txt";

    public static void main(String[] args) {
        System.out.print("Enter text: ");
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();

        if (Objects.isNull(input)) {
            System.out.println("Number of words: 0");
            return;
        }

        final WordCounter wordCounter = new WordCounter();
        final int count = wordCounter.count(input, STOPWORDS_TXT);
        System.out.println("Number of words: " + count);
    }
}
