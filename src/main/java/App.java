import WordsCount.InputProvider;
import WordsCount.Filter;
import WordsCount.WordProvider;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

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

        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");

        List<String> stopwords = InputProvider.getInputFromResourceFile("stopwords.txt");

        List<String> matching = Filter.filterWords(pattern.asPredicate().and((word) -> !stopwords.contains(word)), words);
        Set<String> unique = Filter.filterUniqueWords(matching);

        System.out.printf("Number of words: %s, unique: %s\n", matching.size(), unique.size());

    }
}
