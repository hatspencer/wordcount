package WordsCount;

import WordsCount.WordProvider;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class WordProviderTest {

    @Test
    public void testGetWords() {
        String input = " test input   ";
        String[] expected = new String[]{"test", "input"};
        String[] result = new WordProvider().getWords(input);

        assertArrayEquals(expected, result);
    }
}
