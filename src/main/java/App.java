import WordsCount.InputProvider;
import WordsCount.WordCounter;
import WordsCount.WordProvider;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        String[] words;

        WordProvider wp = new WordProvider();

        if (args.length >= 1) {
            String path = args[0];
            List<String> input = InputProvider.getInputFromFile(path);
            words = wp.getWords(input);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter text: ");
            String text = scanner.nextLine();

            words = wp.getWords(text);
        }

        List<String> stopwords = InputProvider.getInputFromResourceFile("stopwords.txt");

        WordCounter wc = new WordCounter(stopwords);

        System.out.printf("Number of words: %s, unique: %s; average word length: %s characters\n", wc.countWords(words), wc.countUniqueWords(words), wc.countAverageWordLength(words));

    }
}
