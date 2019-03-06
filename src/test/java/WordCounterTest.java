import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.erste.main.WordCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {

    private static final List<String> INPUT = Arrays.asList("ERSTE", "GROUP", "Interview", "March");
    private static final List<String> INPUT_WITH_DUPLICATES = Arrays.asList("ERSTE", "GROUP", "Interview", "March", "March");
    private static final List<String> STOP_WORDS = Arrays.asList("ERSTE", "GROUP");

    @Test
    public void countAlphabeticWords() {
        WordCounter wordCounter = new WordCounter(INPUT, STOP_WORDS);
        long wordCount = getAlphabeticWordCount(wordCounter);

        Assertions.assertEquals(2, wordCount);
    }

    @Test
    public void countAlphabeticWordsWithEmptyInput() {
        WordCounter wordCounter = new WordCounter(Collections.EMPTY_LIST, STOP_WORDS);
        long wordCount = getAlphabeticWordCount(wordCounter);

        Assertions.assertEquals(0, wordCount);
    }

    @Test
    public void countAlphabeticWordsWithEmptyStopWords() {
        WordCounter wordCounter = new WordCounter(INPUT, Collections.EMPTY_LIST);
        long wordCount = getAlphabeticWordCount(wordCounter);

        Assertions.assertEquals(4, wordCount);
    }

    @Test
    public void countUniqueAlphabeticWords() {
        WordCounter wordCounter = new WordCounter(INPUT_WITH_DUPLICATES, STOP_WORDS);

        long wordCount = getAlphabeticWordCount(wordCounter);
        long uniqueWordCount = getUniqueWordCount(wordCounter);

        Assertions.assertEquals(3, wordCount);
        Assertions.assertEquals(2, uniqueWordCount);
    }

    @Test
    public void countUniqueAlphabeticWordsWithEmptyInput() {
        WordCounter wordCounter = new WordCounter(Collections.EMPTY_LIST, STOP_WORDS);

        long wordCount = getAlphabeticWordCount(wordCounter);
        long uniqueWordCount = getUniqueWordCount(wordCounter);

        Assertions.assertEquals(0, wordCount);
        Assertions.assertEquals(0, uniqueWordCount);
    }

    @Test
    public void countUniqueAlphabeticWordsWithEmptyStopWords() {
        WordCounter wordCounter = new WordCounter(INPUT_WITH_DUPLICATES, Collections.EMPTY_LIST);

        long wordCount = getAlphabeticWordCount(wordCounter);
        long uniqueWordCount = getUniqueWordCount(wordCounter);

        Assertions.assertEquals(5, wordCount);
        Assertions.assertEquals(4, uniqueWordCount);
    }

    private long getAlphabeticWordCount(WordCounter wordCounter) {
        return wordCounter.countAlphabeticWords();
    }

    private long getUniqueWordCount(WordCounter wordCounter) {
        return wordCounter.countUniqueWords();
    }
}
