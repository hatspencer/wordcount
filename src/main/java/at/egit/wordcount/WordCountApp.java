package at.egit.wordcount;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class WordCountApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> stopWords = readStopWords("stopwords.txt");

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

    private static List<String> readStopWords(String fileName) {
        List<String> stopWords = new ArrayList<>();

        try {
            final URI uri = WordCountApp.class.getClassLoader()
                    .getResource(fileName).toURI();
            stopWords = Files.lines(Paths.get(uri))
                    .collect(toList());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return stopWords;
    }
}
