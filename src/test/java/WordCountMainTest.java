import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCountMainTest {

    @Test
    public void testSingleWord() {
        assertEquals(1, WordCountMain.wordCount("word"));
    }

    @Test
    public void testNotSingleWord() {
        assertEquals(0, WordCountMain.wordCount("word2"));
    }

    @Test
    public void testSeveralWords() {
        assertEquals(5, WordCountMain.wordCount("Mary had a little lamb"));
    }
}
