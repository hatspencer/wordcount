package at.george.interview.domain;

import org.junit.Test;

import java.io.File;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class StopWordsTest {

    @Test
    public void returnFalseOnMissingWord() {

        StopWords sut = StopWords.fromList(asList("abc", "def", "ghi"));

        boolean result = sut.isStopWord("xyz");

        assertFalse(result);
    }

    @Test
    public void returnTrueOnExistingWord() {

        StopWords sut = StopWords.fromList(asList("abc", "def", "ghi"));

        boolean result = sut.isStopWord("def");

        assertTrue(result);
    }

    @Test
    public void returnEmptyListOnMissingFile() {
        StopWords stopWords = StopWords.fromFile(new File("/gibt/es/nicht"));

        assertTrue(stopWords.getWordList().isEmpty());
    }

    @Test
    public void returnWordsOfExistingFile() {
        StopWords stopWords = StopWords.fromFile(new File("src/main/resources/stopwords.txt"));

        assertEquals(asList("the", "a", "on", "off"), stopWords.getWordList());
    }

    @Test
    public void returnWordsOfMainFile() {
        StopWords stopWords = StopWords.getInstance();

        assertEquals(asList("the", "a", "on", "off"), stopWords.getWordList());
    }

    @Test
    public void checkForSingleton() {
        assertSame(StopWords.getInstance(), StopWords.getInstance());
    }

}