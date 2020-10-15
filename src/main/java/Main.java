import solver.WordCounter;
import util.WordsReaderFromFile;

import java.util.Scanner;

/**
 * Created by Marton Bartal on 15.10.2020.
 */
public class Main {

    private static final String STOPWORDS_FILENAME = "src/main/resources/stopwords.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input your text for word counting.");
        String userInput = scanner.nextLine();

        WordsReaderFromFile wordsReaderFromFile = new WordsReaderFromFile(STOPWORDS_FILENAME);
        WordCounter wordCounter = new WordCounter(wordsReaderFromFile.readWordsFromFile());
        System.out.println("Number of words: " + wordCounter.countWords(userInput));
    }
}
