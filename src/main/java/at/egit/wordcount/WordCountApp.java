package at.egit.wordcount;

import java.util.Scanner;

public class WordCountApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");

        final String textLine = scanner.nextLine();

        final InputValidation inputValidation = new InputValidation();

        if (!inputValidation.validate(textLine)) {
            System.out.println("Only letters and spaces are allowed!");
        } else {
            final WordCount wordCount = new WordCount();
            final long count = wordCount.countWords(textLine);

            System.out.println("Number of words: " + count);
        }

    }
}
