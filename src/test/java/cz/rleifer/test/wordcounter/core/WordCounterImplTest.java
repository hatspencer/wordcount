package cz.rleifer.test.wordcounter.core;


import org.junit.Assert;
import org.junit.Test;

public class WordCounterImplTest {

    private WordCounter wordCounter = new WordCounterImpl();

    @Test
    public void testCounterSpecialCharacters() {
        int numberOfWords = wordCounter.countWords("&^&^");
        Assert.assertEquals(0, numberOfWords);
    }

    @Test
    public void testCounterBasicInput() {
        int numberOfWords = wordCounter.countWords("Hello Holla \\n Amigo");
        Assert.assertEquals(3, numberOfWords);
    }

    @Test
    public void testCounterNumbers() {
        int numberOfWords = wordCounter.countWords("First1 Second2 Third");
        Assert.assertEquals(1, numberOfWords);
    }
}
