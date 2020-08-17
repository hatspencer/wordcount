import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class WordAppTest {

    private static WordsCounter testClass;

    @BeforeClass
    public static void setup() {
        testClass = new WordsCounter();
    }

    @Test
    public void shouldCountWordsOnlyMatchingInput() {
        String input = "aaa bbb ccc ddd";
        int result = testClass.countWords(input);
        assertEquals(4, result);
    }

    @Test
    public void shouldCountWordsIgnoreNumbersSpecialChars() {
        String input = "aaa bbb b2b ccć ąą 22";
        int result = testClass.countWords(input);
        assertEquals(2, result);
    }

    @Test
    public void shouldReturnZeroForNoInput() {
        String input = "";
        int result = testClass.countWords(input);
        assertEquals(0, result);
    }
}
