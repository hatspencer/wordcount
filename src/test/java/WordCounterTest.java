import java.util.Arrays;
import java.util.List;

import com.erste.main.WordCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {

    @Test
    public void countAlphabeticWords() {
        List<String> input = Arrays.asList("ERSTE", "GROUP", "Interview", "March");
        List<String> stopWords = Arrays.asList("ERSTE", "GROUP");

        WordCounter wordCounter = new WordCounter(input, stopWords);
        long wordCount = wordCounter.countAlphabeticWords();

        Assertions.assertEquals(2, wordCount);
    }
}
