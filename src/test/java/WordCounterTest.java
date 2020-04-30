import org.junit.Ignore;
import org.junit.Test;
import wordreader.FileWordReader;
import wordreader.StopWordReader;
import wordreader.WordReader;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WordCounterTest {

    private final WordCounter wordCounter;

    public WordCounterTest() {

        WordReader stopWordReader = new StopWordReader(); // we can also mock this
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

    @Test
    public void wordCountTest() {

        assertEquals(1, wordCounter.countWords(List.of("word")));
        assertEquals(2, wordCounter.countWords(List.of("word", "word")));
        assertEquals(2, wordCounter.countWords(List.of("word", "6fdf", "uionj")));
        assertEquals(0, wordCounter.countWords(List.of("   ")));

    }

    @Test
    public void stopWordTest() {

        assertEquals(4, wordCounter.countWords(List.of("Mary", "had", "a", "little", "lamb")));
        assertEquals(1, wordCounter.countWords(List.of("  ", "the", "   ", "a", "b", " on", "off")));
        assertEquals(0, wordCounter.countWords(List.of("the", "the", "the")));
        assertEquals(1, wordCounter.countWords(List.of("the", " Mary", "the")));

    }

    @Test
    public void customFileTest() {
        FileWordReader fileWordReader = new FileWordReader("src/main/resources/mytext.txt");
        assertEquals(4, wordCounter.countWords(fileWordReader.readWords()));
    }

//    @Test
//    public void uniqueFileTest() {
//        FileWordReader fileWordReader = new FileWordReader("src/main/resources/uniquewords.txt");
//        assertEquals(9, wordCounter.countWords(fileWordReader.readWords()));
//        assertEquals(7, wordCounter.countUniqueWords(fileWordReader.readWords()));
//    }

}
