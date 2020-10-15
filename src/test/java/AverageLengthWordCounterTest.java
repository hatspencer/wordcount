import org.junit.Test;
import service.WordCounter;
import service.impl.WordCounterImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the average length of words calculation.
 */
public class AverageLengthWordCounterTest {

    private static final List<String> stopWords = Arrays.asList("aa", "the", "on", "off");

    private static final String WRONG_WORD_CNT_ERR_MSG = "Wrong word count.";
    private WordCounter wordCounter = new WordCounterImpl(stopWords);

    @Test
    public void testUniqueWordCountMaryExample() {

        String testText = "Mary Mary Mary Mary Mary";
        double expected = 4;
        double result = wordCounter.processInput(testText).getAvgWordLength();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result, 0.0);
    }

    @Test
    public void testWordCount1WordExample() {

        String testText = "Mary";
        double expected = 4;
        double result = wordCounter.processInput(testText).getAvgWordLength();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result, 0.0);
    }

    @Test
    public void testWordCountMaryWithNegativeWordExample() {

        String testText = "Mar2y Marie Mary Mary Mary Mary";
        double expected = 4.2;
        double result = wordCounter.processInput(testText).getAvgWordLength();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result, 0.0);
    }

    @Test
    public void testWordCountWithOnlyWhiteSpace() {

        String testText = "      ";
        double expected = 0;
        double result = wordCounter.processInput(testText).getAvgWordLength();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result, 0.0);
    }

    @Test
    public void testWordCountEmpty() {

        String testText = "";
        double expected = 0;
        double result = wordCounter.processInput(testText).getAvgWordLength();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result, 0.0);
    }

    @Test
    public void testWordCountNewLineInText() {

        String testText = "Mary\nMary";
        double expected = 4;
        double result = wordCounter.processInput(testText).getAvgWordLength();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result, 0.0);
    }

    @Test
    public void testWordCountStopWordsNotIncluded() {

        String testText = "Mary had two little lambs";
        double expected = 4.2;
        double result = wordCounter.processInput(testText).getAvgWordLength();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result, 0.0);
    }

    @Test
    public void testWordCountAllStopWordsIncluded() {

        String testText = "the aa on off";
        double expected = 0;
        double result = wordCounter.processInput(testText).getAvgWordLength();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result, 0.0);
    }

    @Test
    public void testWordCountWithDash() {

        String testText = "Humpty-Dumpty satsats on aa wall. Humpty-Dumpty had aa great fall.";

        double expected = 7;
        double result = wordCounter.processInput(testText).getAvgWordLength();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result, 0.0);
    }
}
