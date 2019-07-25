package eu.wordcount.counter;

import eu.wordcount.StopWordsReader;
import eu.wordcount.WordCounter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StoppableWordCounter implements WordCounter {

    private final StopWordsReader stopWordsReader;

    public StoppableWordCounter(StopWordsReader stopWordsReader) {
        this.stopWordsReader = stopWordsReader;
    }

    @Override
    public int countWords(String input) {
        int count = 0;

        List<String> stopWords = stopWordsReader.readWords();

        if (input != null) {

            Pattern p = Pattern.compile("[a-zA-Z]+");
            Matcher m = p.matcher(input);   // get a matcher object

            while (m.find()) {
                if (!stopWords.contains(m.group())) {
                    count++;
                }
            }
        }

        return count;
    }
}
