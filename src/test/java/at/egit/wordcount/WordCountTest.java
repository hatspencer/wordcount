package at.egit.wordcount;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordCountTest {

    private WordCount wordCount = new WordCount();

    @Test
    public void whenOneWord_thenShouldReturnOne() {
        final String input = "word";

        final long actualCount = wordCount.countWords(input);

        assertEquals("Should be 1", 1, actualCount);
    }

    @Test
    public void whenMultipleWordsCount_thenReturnCorrectNumber() {
        final String input = "word1 word2";

        final long actualCount = wordCount.countWords(input);

        assertEquals("Should be 2", 2, actualCount);
    }

    @Test
    public void whenInputContainsConsequentSpace_thenSkipSpaces() {
        final String input = "word1    word2";

        final long actualCount = wordCount.countWords(input);

        assertEquals("Should be 2", 2, actualCount);
    }

    @Test
    public void whenNullInput_thenReturnZero() {
        final long actualCount = wordCount.countWords(null);

        assertEquals("Should be 0", 0, actualCount);
    }

    @Test
    public void whenNonAlphabeticWordsArePresent_thenShouldNotIgnoreThem() {
        final String input = "123";

        final long actualCount = wordCount.countWords(input);

        assertEquals("Should be 1", 1, actualCount);
    }

    @Test
    public void whenInputContainsStopWords_thenIgnoreThem() {
        final List<String> stopWords = Arrays.asList("one", "two");
        wordCount.setStopWords(stopWords);

        final String input = "one word";

        final long actualCount = wordCount.countWords(input);

        assertEquals(1, actualCount);
    }

    @Test
    public void whenInputContainsOnlyStopWords_thenReturnZero() {
        final List<String> stopWords = Arrays.asList("one", "two");
        wordCount.setStopWords(stopWords);

        final String input = "one two one";

        final long actualCount = wordCount.countWords(input);

        assertEquals(0, actualCount);
    }

    @Test
    public void setStopWordsToNull() {
        wordCount.setStopWords(null);

        final String input = "one two one";

        final long actualCount = wordCount.countWords(input);

        assertEquals(3, actualCount);
    }
}
