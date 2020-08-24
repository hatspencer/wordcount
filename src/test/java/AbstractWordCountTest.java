import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbstractWordCountTest {

    public static class TestWordCount extends AbstractWordCount {
        @Override
        public BufferedReader getInput() {
            return null;
        }

        public TestWordCount() throws IOException {
        }
    }

    @Test
    public void testSingleWord() throws IOException {
        AbstractWordCount app = new TestWordCount();
        assertEquals(1, app.wordCountInList(Arrays.asList("word")));
    }

    @Test
    public void testNotSingleWord() throws IOException {
        AbstractWordCount app = new TestWordCount();
        assertEquals(0, app.wordCountInList(Arrays.asList("word2")));
    }

    @Test
    public void testSeveralWords() throws IOException {
        AbstractWordCount app = new TestWordCount();
        assertEquals(4, app.wordCountInList(Arrays.asList("Mary had a little lamb")));
    }

    @Test
    public void testSeveralLines() throws IOException {
        AbstractWordCount app = new TestWordCount();
        assertEquals(6, app.wordCountInList(Arrays.asList("Mary had a little lamb", "another line")));
    }

    @Test
    public void testReadStopwords() throws IOException {
        AbstractWordCount app = new TestWordCount();
        assertTrue(app.stopwords.contains("the"));
        assertTrue(app.stopwords.contains("a"));
        assertTrue(app.stopwords.contains("on"));
        assertTrue(app.stopwords.contains("off"));
    }
}
