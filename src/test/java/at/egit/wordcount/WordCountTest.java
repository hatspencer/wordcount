package at.egit.wordcount;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordCountTest {

    private WordCount wordCount = new WordCount();

    @Test
    public void whenOneWord_thenShouldReturnOneTest() {
        final String input = "word";

        final long actualCount = wordCount.countWords(input);

        assertEquals("Should be 1", 1, actualCount);
    }

    @Test
    public void whenMultipleWordsCount_thenReturnCorrectNumberTest() {
        final String input = "word1 word2";

        final long actualCount = wordCount.countWords(input);

        assertEquals("Should be 2", 2, actualCount);
    }

    @Test
    public void whenInputContainsConsequentSpace_thenSkipSpacesTest() {
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
}
