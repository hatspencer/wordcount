package com.erstegroup.hiring;

import org.junit.Test;

public class WordCountTest {

    @Test
    public void wordCount() {
        String text = "Mary had a little lamb";

        int wordCount = WordCount.wordCount(text);

        org.junit.Assert.assertEquals(5, wordCount);
    }

    @Test
    public void wordCountWithDoubleSpace() {
        String text = "Mary      had  a little lamb";

        int wordCount = WordCount.wordCount(text);

        org.junit.Assert.assertEquals(5, wordCount);
    }
}
