import org.junit.Test;

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
    public void countWordsReturnsCorrectNumberOfWords() {
        String twoWords = "foo bar";

        long result = WordCounter.countWords(twoWords);

        assertEquals(2, result);
    }

    @Test
    public void countWordsReturnsCorrectNumberOfWordsWithMultipleSpaces() {
        String twoWords = "foo     bar";

        long result = WordCounter.countWords(twoWords);

        assertEquals(2, result);
    }


    @Test
    public void isValidInputShouldReturnTrueOnNoInput() {
        String noInput = "";

        boolean result = WordCounter.isValidInput(noInput);

        assertTrue(result);
    }

    @Test
    public void countWordsReturnsZeroOnNoInput() {
        String noInput = "";

        long result = WordCounter.countWords(noInput);

        assertEquals(0, result);
    }

    @Test
    public void countWordsReturnsZeroOnEmptyInput() {
        String emptyInput = " ";

        long result = WordCounter.countWords(emptyInput);

        assertEquals(0, result);
    }

}
