package at.george.interview.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordCounterTest {

    @Test
    public void emptyInputReturnsZero() {

        WordCounter sut = new WordCounter();

        long result = sut.countWords("");

        assertEquals(result, 0);
    }

    @Test
    public void whitespaceOnlyInputReturnsUZero() {

        WordCounter sut = new WordCounter();

        long result = sut.countWords("        ");

        assertEquals(result, 0);
    }

    @Test
    public void singleWordReturnsOne() {

        WordCounter sut = new WordCounter();

        long result = sut.countWords("hello");

        assertEquals(result, 1);
    }

    @Test
    public void twoWordsReturnsTwo() {

        WordCounter sut = new WordCounter();

        long result = sut.countWords("hello there");

        assertEquals(result, 2);
    }

    @Test
    public void nonalphabeticWordIsIgnored() {

        WordCounter sut = new WordCounter();

        long result = sut.countWords("hello1world");

        assertEquals(result, 0);
    }

}