package wordcount;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Counts the words in the text read from standard input.
 * 
 * @author Nándor Előd Fekete
 */
public class WordCountApp {

    public static void main(String[] args) throws IOException {
        System.out.print("Enter text: ");
        final WordCounter wordCounter = new WordCounter();
        final long wordCount = wordCounter.wordCount(new ValidWordTokenizer(new InputStreamReader(System.in)));
        System.out.printf("Number of words: %d", wordCount);
    }

}
