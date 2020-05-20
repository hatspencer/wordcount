package cz.rleifer.test.wordcounter.core;


import cz.rleifer.test.wordcounter.core.impl.WordCounterImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class WordCounterImplTest {

    private WordCounter wordCounter = new WordCounterImpl();

    @Test
    public void testCounterSpecialCharacters() {
        int numberOfWords = wordCounter.countWords("&^&^", Collections.EMPTY_LIST);
        Assert.assertEquals(0, numberOfWords);
    }

    @Test
    public void testCounterBasicInput() {
        int numberOfWords = wordCounter.countWords("Hello Holla \\n Amigo",  Collections.EMPTY_LIST);
        Assert.assertEquals(3, numberOfWords);
    }

    @Test
    public void testCounterNumbers() {
        int numberOfWords = wordCounter.countWords("First1 Second2 Third",  Collections.EMPTY_LIST);
        Assert.assertEquals(1, numberOfWords);
    }

    @Test
    public void testStopWords() {
        int numberOfWords = wordCounter.countWords("First1 Second2 third",  Collections.singletonList("third"));
        Assert.assertEquals(0, numberOfWords);
    }

    @Test
    public void testStopWordsCaseInsensitive() {
        int numberOfWords = wordCounter.countWords("First1 Second2 Third",  Collections.singletonList("third"));
        Assert.assertEquals(0, numberOfWords);
    }
}
