package at.george.interview.domain;

import at.george.interview.domain.counters.AlphabeticWordCounter;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlphabeticWordCounterTest {

    @Test
    public void emptyInputReturnsZero() {

        AlphabeticWordCounter sut = new AlphabeticWordCounter();

        long result = sut.countWords("");

        assertEquals(result, 0);
    }

    @Test
    public void whitespaceOnlyInputReturnsUZero() {

        AlphabeticWordCounter sut = new AlphabeticWordCounter();

        long result = sut.countWords("        ");

        assertEquals(result, 0);
    }

    @Test
    public void singleWordReturnsOne() {

        AlphabeticWordCounter sut = new AlphabeticWordCounter();

        long result = sut.countWords("hello");

        assertEquals(result, 1);
    }

    @Test
    public void twoWordsReturnsTwo() {

        AlphabeticWordCounter sut = new AlphabeticWordCounter();

        long result = sut.countWords("hello there");

        assertEquals(result, 2);
    }

    @Test
    public void nonalphabeticWordIsIgnored() {

        AlphabeticWordCounter sut = new AlphabeticWordCounter();

        long result = sut.countWords("hello1world");

        assertEquals(result, 0);
    }

    @Test
    public void ignoreSingleNonAlphabeticElements() {

        AlphabeticWordCounter sut = new AlphabeticWordCounter();

        long result = sut.countWords("hello ? # ??? &");

        assertEquals(result, 1);
    }


}