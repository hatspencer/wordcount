import org.junit.Test;
import solver.WordCounter;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the word counter class.
 */
public class UniqueWordCounterTest {

    private static final List<String> stopWords = Arrays.asList("aa", "the", "on", "off");

    private static final String WRONG_WORD_CNT_ERR_MSG = "Wrong word count.";
    private WordCounter wordCounter = new WordCounter(stopWords);

    @Test
    public void testUniqueWordCountMaryExample() {

        String testText = "Mary Mary Mary Mary Mary";
        int expected = 1;
        int result = wordCounter.solve(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCount1WordExample() {

        String testText = "Mary";
        int expected = 1;
        int result = wordCounter.solve(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountMaryWithNegativeWordExample() {

        String testText = "Mar2y Marie Mary Mary Mary Mary";
        int expected = 2;
        int result = wordCounter.solve(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountWithOnlyWhiteSpace() {

        String testText = "      ";
        int expected = 0;
        int result = wordCounter.solve(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountEmpty() {

        String testText = "";
        int expected = 0;
        int result = wordCounter.solve(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountNewLineInText() {

        String testText = "Mary\nMary";
        int expected = 1;
        int result = wordCounter.solve(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountStopWordsNotIncluded() {

        String testText = "Mary had two little lambs";
        int expected = 5;
        int result = wordCounter.solve(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountAllStopWordsIncluded() {

        String testText = "the aa on off";
        int expected = 0;
        int result = wordCounter.solve(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountWithDash() {

        String testText = "Humpty-Dumpty sat on aa wall. Humpty-Dumpty had aa great fall.";

        int expected = 7;
        int result = wordCounter.solve(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }
}
