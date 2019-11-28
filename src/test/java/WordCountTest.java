import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class WordCountTest {

    @Test
    public void countShouldCountWords() {
        String userInput = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "a", "on", "off"));

        WordCount wordCount = new WordCount(userInput, stopWords);
        WordCount.CountingResult result = wordCount.count();

        assertEquals(9, result.getWordsCount());
        assertEquals(7, result.getUniqueWordsCount());
    }

    @Test
    public void countShouldCountWordsNoStopWords() {
        String userInput = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        Set<String> stopWords = Collections.emptySet();

        WordCount wordCount = new WordCount(userInput, stopWords);
        WordCount.CountingResult result = wordCount.count();

        assertEquals(12, result.getWordsCount());
        assertEquals(9, result.getUniqueWordsCount());
    }

}