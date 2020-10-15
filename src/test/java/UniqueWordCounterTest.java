import org.junit.Test;
import service.impl.WordCounterImpl;
import service.WordCounter;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the unique word calculation.
 */
public class UniqueWordCounterTest {

    private static final List<String> stopWords = Arrays.asList("aa", "the", "on", "off");

    private static final String WRONG_UNIQUE_WORD_CNT_ERR_MSG = "Wrong unique word count.";
    private WordCounter wordCounter = new WordCounterImpl(stopWords, false);

    @Test
    public void testUniqueWordCountMaryExample() {

        String testText = "Mary Mary Mary Mary Mary";
        int expected = 1;
        int result = wordCounter.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_UNIQUE_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testUniqueWordCount1WordExample() {

        String testText = "Mary";
        int expected = 1;
        int result = wordCounter.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_UNIQUE_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testUniqueWordCountMaryWithNegativeWordExample() {

        String testText = "Mar2y Marie Mary Mary Mary Mary";
        int expected = 2;
        int result = wordCounter.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_UNIQUE_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testUniqueWordCountWithOnlyWhiteSpace() {

        String testText = "      ";
        int expected = 0;
        int result = wordCounter.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_UNIQUE_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testUniqueWordCountEmpty() {

        String testText = "";
        int expected = 0;
        int result = wordCounter.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_UNIQUE_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testUniqueWordCountNewLineInText() {

        String testText = "Mary\nMary";
        int expected = 1;
        int result = wordCounter.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_UNIQUE_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testUniqueWordCountStopWordsNotIncluded() {

        String testText = "Mary had two little lambs";
        int expected = 5;
        int result = wordCounter.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_UNIQUE_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testUniqueWordCountAllStopWordsIncluded() {

        String testText = "the aa on off";
        int expected = 0;
        int result = wordCounter.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_UNIQUE_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testUniqueWordCountWithDash() {

        String testText = "Humpty-Dumpty sat on aa wall. Humpty-Dumpty had aa great fall.";

        int expected = 6;
        int result = wordCounter.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_UNIQUE_WORD_CNT_ERR_MSG, expected, result);
    }
}
