package wordcount;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * @author Nándor Előd Fekete
 */
public class DefaultWordCounterTest {

    @Test
    public void emptyTest() throws IOException {
        final WordCounter wordCounter = new WordCounter();
        assertEquals("Word count for the empty string should be 0", 0, wordCounter.wordCount(new StringReader("")));
    }

    @Test
    public void testCharacterBlockWithNonWordCharacters() throws IOException {
        final WordCounter wordCounter = new WordCounter();
        assertEquals("Foo$Bar should not be counted as a word", 0, wordCounter.wordCount(new StringReader("Foo$Bar")));
    }


}
