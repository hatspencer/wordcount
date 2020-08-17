import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
public class WordAppTest {

    private static WordsCounter testClass;

    @BeforeClass
    public static void setup() {
        testClass = new WordsCounter();
    }

    @Test
    public void shouldCountWordsOnlyMatchingInputNoStopWords() {
        String input = "aaa bbb ccc ddd";
        List<String> stopWords = Collections.singletonList("");
        int result = testClass.countWords(input, stopWords);
        assertEquals(4, result);
    }

    @Test
    public void shouldCountWordsIgnoreNumbersSpecialCharsSeparateLinesStopWords() {
        String input = "aaa bbb b2b ccć ąą 22 cc dd  ";
        List<String> stopWords = Arrays.asList("aaa", "dd");
        int result = testClass.countWords(input, stopWords);
        assertEquals(2, result);
    }

    @Test
    public void shouldCountWordsIgnoreNumbersSpecialCharsOneLineStopWords() {
        String input = "aaa bbb b2b ccć ąą 22 cc dd  ";
        List<String> stopWords = Arrays.asList("aaa bbb", "dd");
        int result = testClass.countWords(input, stopWords);
        assertEquals(1, result);
    }

    @Test
    public void shouldReturnZeroForNoInput() {
        String input = "";
        List<String> stopWords = Collections.singletonList("");
        int result = testClass.countWords(input, stopWords);
        assertEquals(0, result);
    }
}
