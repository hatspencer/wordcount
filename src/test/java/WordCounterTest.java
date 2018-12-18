import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordCounterTest {

    @Test
    public void isValidInputShouldReturnFalseOnInvalidInput() {
        String invalidInput = "foo bar1";

        boolean result = WordCounter.isValidInput(invalidInput);

        assertFalse(result);
    }

    @Test
    public void isValidInputShouldReturnTrueOnValidInput() {
        String validInput = "foo bar";

        boolean result = WordCounter.isValidInput(validInput);

        assertTrue(result);
    }

    @Test
    public void isValidInputShouldReturnTrueOnNoInput() {
        String noInput = "";

        boolean result = WordCounter.isValidInput(noInput);

        assertTrue(result);
    }

    @Test
    public void countWordsReturnsCorrectNumberOfWords() {
        String twoWords = "foo bar";

        long result = WordCounter.countValidWords(twoWords);

        assertEquals(2, result);
    }

    @Test
    public void countWordsReturnsCorrectNumberOfWordsWithMultipleSpaces() {
        String twoWords = "foo     bar";

        long result = WordCounter.countValidWords(twoWords);

        assertEquals(2, result);
    }

    @Test
    public void countWordsReturnsZeroOnNoInput() {
        String noInput = "";

        long result = WordCounter.countValidWords(noInput);

        assertEquals(0, result);
    }

    @Test
    public void countWordsReturnsZeroOnEmptyInput() {
        String emptyInput = " ";

        long result = WordCounter.countValidWords(emptyInput);

        assertEquals(0, result);
    }

    @Test
    public void countWordsReturnsCorrectNumberOfWordsIgnoringStopWords() {
        List<String> stopWords = Arrays.asList("a", "off", "the", "on");
        String oneInvalidWord = "Mary had a little lamb";

        long result = WordCounter.countValidWords(oneInvalidWord, stopWords);

        assertEquals(4, result);
    }

}
