import wordreader.FileWordReader;
import wordreader.StopWordReader;
import wordreader.WordReader;

import java.util.Collection;

public class WordCounterApp {

    public static void main(String[] args) {

        IsWordReaderFactory wordReaderFactory = new WordReaderFactory();

        final WordReader wordReader = wordReaderFactory.getReader(args);

        WordReader stopWordReader = new StopWordReader();
        WordCounter wordCounter = new WordCounter(stopWordReader);

        Collection<String> words = wordReader.readWords();

        System.out.println(
                "Number of words: " + wordCounter.countWords(words)
                + ", unique: " + wordCounter.countUniqueWords(words)
        );

    }

}
