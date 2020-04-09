package wordcounter;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = null;
        if (args.length > 0) {
            filename = args[0];
        }

        System.out.printf("Number of words: %s", getValidWordsCount(filename));
    }

    private static int getValidWordsCount(String filename) throws FileNotFoundException {
        WordCounter wordCounter = new WordCounter(new StopWords("stopwords.txt"));
        if (filename != null && !filename.isEmpty()) {
            List<String> lines = new InputReader().readFromFile(filename);
            return wordCounter.countValidWords(lines);
        } else {

            String line = new InputReader().readFromSystemIn("Enter text: ");
            return wordCounter.countValidWords(line);
        }
    }
}
