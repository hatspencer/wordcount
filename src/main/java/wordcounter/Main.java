package wordcounter;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        WordCounter wordCounter = new WordCounter(new StopWords("stopwords.txt"));

        String filename = null;
        if (args.length > 0) {
            filename = args[0];
        }

        String text = getText(filename);
        System.out.printf("Number of words: %s, unique: %s", wordCounter.countValidWords(text), wordCounter.countValidUniqueWords(text));
    }

    private static String getText(String filename) throws FileNotFoundException {
        if (filename != null && !filename.isEmpty()) {
           return new InputReader().readFromFile(filename);
        } else {
            return new InputReader().readFromSystemIn("Enter text: ");
        }
    }
}
