package eu.wordcount.counter;

import eu.wordcount.StopWordsReader;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class StoppableWordCounterTest {

    StoppableWordCounter underTest;

    StopWordsReader stopWordsReader;

    @Before
    public void setUp() {

        stopWordsReader = () -> Arrays.asList("the", "a", "on", "off");
        underTest = new StoppableWordCounter(stopWordsReader);
    }

    @Test
    public void whenCountIsCalled_thenCounterShouldSkipOneWord() {
        int expected = 4;
        int actual = underTest.countWords("Mary had a little lamb");
        assertEquals("Counter should return 4 words", expected, actual);
    }
}
