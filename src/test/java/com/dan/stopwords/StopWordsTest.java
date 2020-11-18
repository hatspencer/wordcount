package com.dan.stopwords;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StopWordsTest {

    @Test
    public void when_contains_word_Then_returns_true() {
        StopWords stopWords = StopWords.fromWords("one", "two");

        boolean output = stopWords.contains("one");

        assertTrue(output);
    }

    @Test
    public void when_null_passed_Then_returns_true() {
        StopWords stopWords = StopWords.fromWords("one", "two");

        boolean output = stopWords.contains(null);

        assertFalse(output);
    }

    @Test
    public void when_empty_string_in_set_Then_returns_false() {
        StopWords stopWords = StopWords.fromWords("");

        boolean output = stopWords.contains("");

        assertFalse(output);
    }

    @Test
    public void when_stopwords_empty_Then_returns_false() {
        StopWords stopWords = StopWords.fromWords();

        boolean output = stopWords.contains("one");

        assertFalse(output);
    }

}