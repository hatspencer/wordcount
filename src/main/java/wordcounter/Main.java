package wordcounter;

import java.io.File;
import java.nio.file.Paths;

public class Main{

    public static void main(String[] args) {

        String input = new InputReader().readFromSystemIn("Enter text: ");
        new StopWords();
        WordCounter wordCounter = new WordCounter();

        int validWordsCount = wordCounter.countValidWords(input);

        System.out.printf( "Number of words: %s", validWordsCount);
    }
}
