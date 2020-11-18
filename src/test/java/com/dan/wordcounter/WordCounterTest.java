package com.dan.wordcounter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    WordCounter counter = new WordCounterImpl();

    @Test
    public void when_word_Then_output_is_1() {
        String input = "word";

        final int countWords = counter.countWords(input);

        assertEquals(1, countWords);
    }

    @Test
    public void when_Mary_had_a_little_lamb_Then_output_is_5() {
        String input = "Mary had a little lamb";

        final int countWords = counter.countWords(input);

        assertEquals(5, countWords);
    }

    @Test
    public void when_word_word_word_Then_output_is_3() {
        String input = "word word word";

        final int countWords = counter.countWords(input);

        assertEquals(3, countWords);
    }

    @Test
    public void when_word_word_word_no_whitespace_Then_output_is_0() {
        String input = "word_word_word";

        final int countWords = counter.countWords(input);

        assertEquals(0, countWords);
    }

    @Test
    public void when_word_word2word_word_Then_output_is_2() {
        String input = "word word2word word";

        final int countWords = counter.countWords(input);

        assertEquals(2, countWords);
    }

    @Test
    public void when_special_char_case_Then_output_is_2() {
        String input = "word wo!word word.";

        final int countWords = counter.countWords(input);

        assertEquals(1, countWords);
    }

    @Test
    public void when_special_chars_Then_output_is_0() {
        String input = "!%";

        final int countWords = counter.countWords(input);

        assertEquals(0, countWords);
    }

    @Test
    public void when_empty_string_Then_output_is_0() {
        String input = "";

        final int countWords = counter.countWords(input);

        assertEquals(0, countWords);
    }

    @Test
    public void when_null_Then_output_is_0() {
        String input = null;

        final int countWords = counter.countWords(input);

        assertEquals(0, countWords);
    }

}