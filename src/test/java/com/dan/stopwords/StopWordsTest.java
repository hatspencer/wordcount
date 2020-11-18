package com.dan.stopwords;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StopWordsTest {

    @Test
    public void when_contains_word_then_returns_true() {
        StopWords stopWords = StopWords.fromWords("one", "two");

        boolean output = stopWords.contains("one");

        assertTrue(output);
    }

    @Test
    public void when_null_passed_then_returns_true() {
        StopWords stopWords = StopWords.fromWords("one", "two");

        boolean output = stopWords.contains(null);

        assertFalse(output);
    }

    @Test
    public void when_empty_string_in_set_then_returns_false() {
        StopWords stopWords = StopWords.fromWords("");

        boolean output = stopWords.contains("");

        assertFalse(output);
    }

    @Test
    public void when_stopwords_empty_then_returns_false() {
        StopWords stopWords = StopWords.fromWords();

        boolean output = stopWords.contains("one");

        assertFalse(output);
    }

    @Test
    public void when_stopwords_from_file_then_returns_false() {
        StopWords stopWords = StopWords.fromFile("stopwords.txt");

        boolean output = stopWords.contains("the");

        assertTrue(output);
    }

}