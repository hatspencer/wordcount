package com.dan.words.counter;

import com.dan.stopwords.StopWords;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterImplTest {

    private final StopWords stopWords = StopWords.fromWords("the", "a", "on", "off");

    @Test
    public void when_word_then_output_is_1() {
        String input = "word";

        final int wordCount = countWordsFor(input);

        assertEquals(1, wordCount);
    }

    @Test
    public void when_iter_4_input_then_output_is_7() {
        String input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";

        final int wordCount = countWordsFor(input);

        assertEquals(7, wordCount);
    }

    @Test
    public void when_Mary_had_a_little_lamb_then_output_is_4() {
        String input = "Mary had a little lamb";

        final int wordCount = countWordsFor(input);

        assertEquals(4, wordCount);
    }

    @Test
    public void when_Mary_had_a_little_lamb_with_dot_then_output_is_4() {
        String input = "Mary had a. little lamb";

        final int wordCount = countWordsFor(input);

        assertEquals(4, wordCount);
    }

    @Test
    public void when_on_off_and_then_output_is_1() {
        String input = "on off and";

        final int wordCount = countWordsFor(input);

        assertEquals(1, wordCount);
    }

    @Test
    public void when_word_word_word_then_output_is_3() {
        String input = "word word word";

        final int wordCount = countWordsFor(input);

        assertEquals(3, wordCount);
    }

    @Test
    public void when_word_word_word_no_whitespace_then_output_is_0() {
        String input = "word_word_word";

        final int wordCount = countWordsFor(input);

        assertEquals(0, wordCount);
    }

    @Test
    public void when_wo_dash_rd_word_word_then_output_is_3() {
        String input = "wo-rd word word";

        final int wordCount = countWordsFor(input);

        assertEquals(3, wordCount);
    }

    @Test
    public void when_dash_word_word_word_then_output_is_3() {
        String input = "-word word word";

        final int wordCount = countWordsFor(input);

        assertEquals(3, wordCount);
    }

    @Test
    public void when_word_word2word_word_then_output_is_2() {
        String input = "word word2word word";

        final int wordCount = countWordsFor(input);

        assertEquals(2, wordCount);
    }

    @Test
    public void when_special_char_case_then_output_is_2() {
        String input = "word wo!word word.";

        final int wordCount = countWordsFor(input);

        assertEquals(2, wordCount);
    }

    @Test
    public void when_special_chars_then_output_is_0() {
        String input = "!%";

        final int wordCount = countWordsFor(input);

        assertEquals(0, wordCount);
    }

    @Test
    public void when_empty_string_then_output_is_0() {
        String input = "";

        final int wordCount = countWordsFor(input);

        assertEquals(0, wordCount);
    }

    @Test
    public void when_null_then_output_is_0() {
        String input = null;

        final int wordCount = countWordsFor(input);

        assertEquals(0, wordCount);
    }

    private int countWordsFor(String input) {
        WordCounterImpl counter = new WordCounterImpl(input, stopWords);
        return counter.countWords();
    }

}