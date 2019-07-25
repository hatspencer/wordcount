package eu.wordcount;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    private WordCounter underTest;

    @Before
    public void setUp() {
        underTest = new WordCounter();
    }

    @Test
    public void whenFiveWordsAreInTheInput_thenReturnThree() {
        int expected = 5;
        assertEquals("Number of words should be 5", expected, underTest.countWords("Mary had a little lamb"));
    }


    @Test
    public void whenFiveWordsAndANumberAreInTheInput_thenReturnThree() {
        int expected = 5;
        assertEquals("Number of words should be 5", expected, underTest.countWords("Mary had a little 5 lamb"));
    }

    @Test
    public void whenInputIsNull_thenReturnZero() {
        int expected = 0;
        assertEquals("Number of words should be 5", expected, underTest.countWords(null));
    }

    @Test
    public void whenInputIsEmpty_thenReturnZero() {
        int expected = 0;
        assertEquals("Number of words should be 5", expected, underTest.countWords(""));
    }
}
