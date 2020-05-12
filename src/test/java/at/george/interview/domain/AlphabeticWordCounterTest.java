package at.george.interview.domain;

import at.george.interview.domain.counters.AlphabeticWordCounter;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class AlphabeticWordCounterTest {

    private StopWords stopWords;

    private AlphabeticWordCounter sut;

    @Before
    public void setup() {
        stopWords = StopWords.fromList(asList("you", "me", "her", "him"));
        sut = new AlphabeticWordCounter(stopWords);
    }


    @Test
    public void emptyInputReturnsZero() {

        long result = sut.countWords("");

        assertEquals(result, 0);
    }

    @Test
    public void whitespaceOnlyInputReturnsUZero() {

        long result = sut.countWords("        ");

        assertEquals(result, 0);
    }

    @Test
    public void singleWordReturnsOne() {

        long result = sut.countWords("hello");

        assertEquals(result, 1);
    }

    @Test
    public void twoWordsReturnsTwo() {

        long result = sut.countWords("hello there");

        assertEquals(result, 2);
    }

    @Test
    public void nonalphabeticWordIsIgnored() {

        long result = sut.countWords("hello1world");

        assertEquals(result, 0);
    }

    @Test
    public void ignoreSingleNonAlphabeticElements() {

        long result = sut.countWords("hello ? # ??? &");

        assertEquals(result, 1);
    }

    @Test
    public void ignoreStopWords() {

        long result = sut.countWords("Hello how are you"); // ignore "a"

        assertEquals(result, 3);
    }

}