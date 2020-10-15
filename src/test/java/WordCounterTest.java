import model.Input;
import org.junit.Test;
import solver.WordCounter;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the word counter class.
 */
public class WordCounterTest {

    private static final List<String> stopWords = Arrays.asList("aa", "the", "on", "off");

    private static final String WRONG_WORD_CNT_ERR_MSG = "Wrong word count.";
    private WordCounter wordCounter = new WordCounter(stopWords);

    @Test
    public void testWordCountMaryExample() {

        String testText = "Mary had aa little lamb";
        int expected = 4;
        int result = wordCounter.countWords(testText).getWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCount1WordExample() {

        String testText = "Mary";
        int expected = 1;
        int result = wordCounter.countWords(testText).getWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountMaryWithNegativeWordExample() {

        String testText = "Mar2y had a little lamb";
        int expected = 4;
        int result = wordCounter.countWords(testText).getWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountWithOnlyWhiteSpace() {

        String testText = "      ";
        int expected = 0;
        int result = wordCounter.countWords(testText).getWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountEmpty() {

        String testText = "";
        int expected = 0;
        int result = wordCounter.countWords(testText).getWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountNewLineInText() {

        String testText = "Mary\nHad";
        int expected = 2;
        int result = wordCounter.countWords(testText).getWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    // ITERATION 2

    @Test
    public void testWordCountStopWordsNotIncluded() {

        String testText = "Mary had two little lambs";
        int expected = 5;
        int result = wordCounter.countWords(testText).getWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }

    @Test
    public void testWordCountAllStopWordsIncluded() {

        String testText = "the aa on off";
        int expected = 0;
        int result = wordCounter.countWords(testText).getWordCount();

        assertEquals(WRONG_WORD_CNT_ERR_MSG, expected, result);
    }
}
