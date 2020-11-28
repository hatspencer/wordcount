package com.dan.dictionary;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DictionaryTest {

    @Test
    public void when_match_case_sensitive_then_returns_true() {
        final Dictionary dictionary = DictionaryBuilder.fromWords(true, "one", "TWO");

        boolean output = dictionary.contains("one");

        assertTrue(output);
    }

    @Test
    public void when_uppercase_match_case_sensitive_then_returns_false() {
        final Dictionary dictionary = DictionaryBuilder.fromWords(true, "one", "TWO");

        boolean output = dictionary.contains("ONE");

        assertFalse(output);
    }

    @Test
    public void when_uppercase_match_case_insensitive__then_returns_true() {
        final Dictionary dictionary = DictionaryBuilder.fromWords(false, "one", "TWO");

        boolean output = dictionary.contains("ONE");

        assertTrue(output);
    }

}