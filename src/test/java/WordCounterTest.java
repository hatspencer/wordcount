import org.junit.Test;
import solver.WordCounter;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the word counter class.
 */
public class WordCounterTest {

    private WordCounter wordCounter = new WordCounter();

    @Test
    public void testWordCountMaryExample() {

        String testText = "Mary had a little lamb";
        int expected = 5;
        int result = wordCounter.countWords(testText);

        assertEquals("Wrong word count.", expected, result);
    }

    @Test
    public void testWordCount1WordExample() {

        String testText = "Mary";
        int expected = 1;
        int result = wordCounter.countWords(testText);

        assertEquals("Wrong word count.", expected, result);
    }

    @Test
    public void testWordCountMaryWithNegativeExample() {

        String testText = "Mar2y had a little lamb";
        int expected = 4;
        int result = wordCounter.countWords(testText);

        assertEquals("Wrong word count.", expected, result);
    }

    @Test
    public void testWordCountWithOnlyWhiteSpace() {

        String testText = "      ";
        int expected = 0;
        int result = wordCounter.countWords(testText);

        assertEquals("Wrong word count.", expected, result);
    }

    @Test
    public void testWordCountEmpty() {

        String testText = "";
        int expected = 0;
        int result = wordCounter.countWords(testText);

        assertEquals("Wrong word count.", expected, result);
    }

    @Test
    public void testWordCountNewLineInText() {

        String testText = "Mary\nHad";
        int expected = 2;
        int result = wordCounter.countWords(testText);

        assertEquals("Wrong word count.", expected, result);
    }
}
