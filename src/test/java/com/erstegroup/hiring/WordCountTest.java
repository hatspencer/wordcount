package com.erstegroup.hiring;

import org.junit.Test;

import static java.util.Collections.emptyList;

public class WordCountTest {

    @Test
    public void wordCount() {
        String text = "Mary had a little lamb";

        long wordCount = WordCount.wordCount(text, emptyList());

        org.junit.Assert.assertEquals(5, wordCount);
    }

    @Test
    public void wordCountWithDoubleSpace() {
        String text = "Mary      had  a little lamb";

        long wordCount = WordCount.wordCount(text, emptyList());

        org.junit.Assert.assertEquals(5, wordCount);
    }
}
