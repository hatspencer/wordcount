package word.filter.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import word.filter.WordFilter;

public class ExcludedWordFilterImplTest {

    @Test
    public void testNullStopWords() {
        WordFilter wordFilter = new ExcludedWordFilterImpl(null);
        boolean result = wordFilter.filter("string");
        assertTrue(result);
    }

    @Test
    public void testEmptyCollectionStopWords() {
        WordFilter wordFilter = new ExcludedWordFilterImpl(new ArrayList<>());
        boolean result = wordFilter.filter("string");
        assertTrue(result);
    }

    @Test
    public void testStopWords() {
        List<String> stopWords = new ArrayList<>();
        stopWords.add("stop");
        WordFilter wordFilter = new ExcludedWordFilterImpl(stopWords);
        boolean result = wordFilter.filter("stop");
        assertFalse(result);
    }

    @Test
    public void testStopWordsNullMatch() {
        List<String> stopWords = new ArrayList<>();
        stopWords.add("stop");
        WordFilter wordFilter = new ExcludedWordFilterImpl(stopWords);
        boolean result = wordFilter.filter(null);
        assertFalse(result);
    }

    @Test
    public void testStopWordsEmptyMatch() {
        List<String> stopWords = new ArrayList<>();
        stopWords.add("stop");
        WordFilter wordFilter = new ExcludedWordFilterImpl(stopWords);
        boolean result = wordFilter.filter("");
        assertTrue(result);
    }

    @Test
    public void testStopWordWithWhiteSpacesMatch() {
        List<String> stopWords = new ArrayList<>();
        stopWords.add("stop");
        WordFilter wordFilter = new ExcludedWordFilterImpl(stopWords);
        boolean result = wordFilter.filter("  stop\t");
        assertFalse(result);
    }
}