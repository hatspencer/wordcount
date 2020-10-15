import org.junit.Test;
import solver.WordCounter;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    @Test
    public void testWordCountMaryExample() {

        String testText = "Mary had a little lamb";
        int expected = 5;
        int result = new WordCounter().countWords(testText);

        assertEquals("Wrong word count.", expected, result);
    }
}
