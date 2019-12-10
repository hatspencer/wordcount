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
        final String stringToTest = "";
        final int expectedWordCount = 0;
        final WordCounter wordCounter = new WordCounter();
        final long actual = wordCounter.wordCount(new ValidWordTokenizer(new StringReader(stringToTest)));
        assertEquals("Word count for the empty string should be 0", expectedWordCount, actual);
    }

    @Test
    public void singleValidWordTest() throws IOException {
        final WordCounter wordCounter = new WordCounter();
        final long actual = wordCounter.wordCount(new ValidWordTokenizer(new StringReader("FooBar")));
        assertEquals("FooBar should be counted as a word", 1, actual);
    }

    @Test
    public void blockOfCharsWithoutWordChars() {

    }

    @Test
    public void testCharacterBlockWithNonWordCharacters() throws IOException {
        final WordCounter wordCounter = new WordCounter();
        final long actual = wordCounter.wordCount(new ValidWordTokenizer(new StringReader("Foo$Bar")));
        assertEquals("Foo$Bar should not be counted as a word", 0, actual);
    }


}
