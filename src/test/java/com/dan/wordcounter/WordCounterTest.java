package com.dan.wordcounter;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    WordCounter counter = new WordCounter();

    @Test
    public void when_word_Then_output_is_1() {
        String input = "word";

        final int countWords = counter.countWords(input);

        assertEquals(1, countWords);
    }

    @Test
    public void when_word_word2word_word_Then_output_is_2() {
        String input = "word_word2word_word";

        final int countWords = counter.countWords(input);

        assertEquals(2, countWords);
    }

}