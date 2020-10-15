import org.junit.Test;
import service.WordCounter;
import service.impl.WordCounterImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the unique word calculation.
 */
public class IndexWordCounterTest {

    private static final List<String> stopWords = Arrays.asList("aa", "the", "on", "off");

    private static final String WRONG_INDEX_ERR_MSG = "Wrong index.";
    private WordCounter wordCounter = new WordCounterImpl(stopWords, true);

    @Test
    public void testIndexMaryExample() {

        String testText = "Mary Mary Mary Mary Mary";
        Set<String> expected = new HashSet<>(Arrays.asList("Mary"));
        Set<String> result = wordCounter.processInput(testText).getIndex();

        assertEquals(WRONG_INDEX_ERR_MSG, expected, result);
    }

    @Test
    public void testIndex1WordExample() {

        String testText = "Mary";
        Set<String> expected = new HashSet<>(Arrays.asList("Mary"));
        Set<String> result = wordCounter.processInput(testText).getIndex();

        assertEquals(WRONG_INDEX_ERR_MSG, expected, result);
    }

    @Test
    public void testIndexMaryWithNegativeWordExample() {

        String testText = "Mar2y Marie Mary Mary Mary Mary";
        Set<String> expected = new HashSet<>(Arrays.asList("Mary", "Marie"));
        Set<String> result = wordCounter.processInput(testText).getIndex();

        assertEquals(WRONG_INDEX_ERR_MSG, expected, result);
    }

    @Test
    public void testIndexWithOnlyWhiteSpace() {

        String testText = "      ";
        Set<String> expected = new HashSet<>();
        Set<String> result = wordCounter.processInput(testText).getIndex();

        assertEquals(WRONG_INDEX_ERR_MSG, expected, result);
    }

    @Test
    public void testIndexEmpty() {

        String testText = "";
        Set<String> expected = new HashSet<>();
        Set<String> result = wordCounter.processInput(testText).getIndex();

        assertEquals(WRONG_INDEX_ERR_MSG, expected, result);
    }

    @Test
    public void testIndexNewLineInText() {

        String testText = "Mary\nMary";
        Set<String> expected = new HashSet<>(Arrays.asList("Mary"));
        Set<String> result = wordCounter.processInput(testText).getIndex();

        assertEquals(WRONG_INDEX_ERR_MSG, expected, result);
    }

    @Test
    public void testIndexStopWordsNotIncluded() {

        String testText = "Mary had two little lambs";
        Set<String> expected = new HashSet<>(Arrays.asList("Mary", "had", "two", "little", "lambs"));
        Set<String> result = wordCounter.processInput(testText).getIndex();

        assertEquals(WRONG_INDEX_ERR_MSG, expected, result);
    }

    @Test
    public void testIndexAllStopWordsIncluded() {

        String testText = "the aa on off";
        Set<String> expected = new HashSet<>();
        Set<String> result = wordCounter.processInput(testText).getIndex();

        assertEquals(WRONG_INDEX_ERR_MSG, expected, result);
    }

    @Test
    public void testIndexWithDash() {

        String testText = "Humpty-Dumpty sat on aa wall. Humpty-Dumpty had aa great fall.";

        Set<String> expected =
                new HashSet<>(Arrays.asList("Humpty-Dumpty", "sat", "wall", "had", "great", "fall"));
        Set<String> result = wordCounter.processInput(testText).getIndex();

        assertEquals(WRONG_INDEX_ERR_MSG, expected, result);
    }
}
