package word.match.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import word.match.WordMatcher;

public class ExcludeStopWordMatcherImplTest {

    @Test
    public void testNullStopWords() {
        WordMatcher wordMatcher = new ExcludeStopWordMatcherImpl(null);
        boolean result = wordMatcher.match("string");
        assertTrue(result);
    }

    @Test
    public void testEmptyCollectionStopWords() {
        WordMatcher wordMatcher = new ExcludeStopWordMatcherImpl(new ArrayList<>());
        boolean result = wordMatcher.match("string");
        assertTrue(result);
    }

    @Test
    public void testStopWords() {
        List<String> stopWords = new ArrayList<>();
        stopWords.add("stop");
        WordMatcher wordMatcher = new ExcludeStopWordMatcherImpl(stopWords);
        boolean result = wordMatcher.match("stop");
        assertFalse(result);
    }

    @Test
    public void testStopWordsNullMatch() {
        List<String> stopWords = new ArrayList<>();
        stopWords.add("stop");
        WordMatcher wordMatcher = new ExcludeStopWordMatcherImpl(stopWords);
        boolean result = wordMatcher.match(null);
        assertFalse(result);
    }

    @Test
    public void testStopWordsEmptyMatch() {
        List<String> stopWords = new ArrayList<>();
        stopWords.add("stop");
        WordMatcher wordMatcher = new ExcludeStopWordMatcherImpl(stopWords);
        boolean result = wordMatcher.match("");
        assertTrue(result);
    }

    @Test
    public void testStopWordWithWhiteSpacesMatch() {
        List<String> stopWords = new ArrayList<>();
        stopWords.add("stop");
        WordMatcher wordMatcher = new ExcludeStopWordMatcherImpl(stopWords);
        boolean result = wordMatcher.match("  stop\t");
        assertFalse(result);
    }
}