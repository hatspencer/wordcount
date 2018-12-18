package at.egit.wordcount;

import java.util.List;
import java.util.Scanner;

public class WordCountApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinesReader linesReader = new LinesReader();
        List<String> stopWords = linesReader.readAllLines("stopwords.txt");

        System.out.print("Enter text: ");

        final String textLine = scanner.nextLine();

        final InputValidation inputValidation = new InputValidation();

        if (!inputValidation.validate(textLine)) {
            System.out.println("Only letters and spaces are allowed!");
        } else {
            final WordCount wordCount = new WordCount();
            wordCount.setStopWords(stopWords);
            final long count = wordCount.countWords(textLine);

            System.out.println("Number of words: " + count);
        }
    }
}
