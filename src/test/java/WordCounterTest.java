import org.junit.Test;
import wordreader.FileWordReader;

import static org.junit.Assert.*;

public class WordCounterTest {

    private final WordCounter wordCounter;

    public WordCounterTest() {

        FileWordReader stopWordReader = new FileWordReader(WordCounterApp.STOP_WORDS_FILENAME); // we can also mock this
        wordCounter = new WordCounter(stopWordReader);
    }

    @Test
    public void wordValidityTest() {

        // ok
        assertTrue(wordCounter.isWord("word"));
        assertTrue(wordCounter.isWord("WOrd"));
        assertTrue(wordCounter.isWord("WORD"));

        // fail
        assertFalse(wordCounter.isWord("wo2rd"));
        assertFalse(wordCounter.isWord(""));
        assertFalse(wordCounter.isWord("  "));
    }

//    @Test
//    public void wordCountTest() {
//
//        assertEquals(1, wordCounter.countWords("word"));
//        assertEquals(2, wordCounter.countWords("word word"));
//        assertEquals(2, wordCounter.countWords("  word    6fdf  uionj"));
//        assertEquals(0, wordCounter.countWords("   "));
//
//    }
//
//    @Test
//    public void stopWordTest() {
//
//        assertEquals(4, wordCounter.countWords("Mary had a little lamb"));
//        assertEquals(1, wordCounter.countWords("  the   a b on off"));
//        assertEquals(0, wordCounter.countWords("the the the"));
//        assertEquals(1, wordCounter.countWords("the Mary the"));
//
//    }

}
