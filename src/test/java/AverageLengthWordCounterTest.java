import org.junit.Test;
import service.WordCounterService;
import service.impl.WordCounterImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the word counter class.
 */
public class AverageLengthWordCounterTest {

    private static final List<String> stopWords = Arrays.asList("aa", "the", "on", "off");

    private static final String WRONG_WORD_CNT_ERR_MSG = "Wrong word count.";
    private WordCounterService wordCounterService = new WordCounterImpl(stopWords);

    @Test
    public void testUniqueWordCountMaryExample() {

        String testText = "Mary Mary Mary Mary Mary";
        double expected = 4;
        double result = wordCounterService.processInput(testText).getAvgWordLength();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCount1WordExample() {

        String testText = "Mary";
        double expected = 4;
        double result = wordCounterService.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountMaryWithNegativeWordExample() {

        String testText = "Mar2y Marie Mary Mary Mary Mary";
        double expected = 4.25;
        double result = wordCounterService.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountWithOnlyWhiteSpace() {

        String testText = "      ";
        double expected = 0;
        double result = wordCounterService.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountEmpty() {

        String testText = "";
        double expected = 0;
        double result = wordCounterService.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountNewLineInText() {

        String testText = "Mary\nMary";
        double expected = 4;
        double result = wordCounterService.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountStopWordsNotIncluded() {

        String testText = "Mary had two little lambs";
        double expected = 4.2;
        double result = wordCounterService.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountAllStopWordsIncluded() {

        String testText = "the aa on off";
        double expected = 0;
        double result = wordCounterService.processInput(testText).getUniqueWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

//    @Test
//    public void testWordCountWithDash() {
//
//        String testText = "Humpty-Dumpty sat on aa wall. Humpty-Dumpty had aa great fall.";
//
//        double expected = 6;
//        double result = wordCounterService.processInput(testText).getUniqueWordCount();
//
//        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
//    }
}
