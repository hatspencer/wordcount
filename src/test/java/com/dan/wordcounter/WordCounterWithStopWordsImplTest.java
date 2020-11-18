package com.dan.wordcounter;

import com.dan.stopwords.StopWords;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterWithStopWordsImplTest {

    WordCounter counter = new WordCounterWithStopWordsImpl(StopWords.fromWords());

    @Test
    public void when_word_then_output_is_1() {
        String input = "word";

        final int countWords = counter.countWords(input);

        assertEquals(1, countWords);
    }

    @Test
    public void when_Mary_had_a_little_lamb_then_output_is_4() {
        String input = "Mary had a little lamb";

        StopWords stopWords = StopWords.fromWords("the", "a", "on", "off");
        counter = new WordCounterWithStopWordsImpl(stopWords);

        final int countWords = counter.countWords(input);

        assertEquals(4, countWords);
    }

    @Test
    public void when_on_off_and_then_output_is_1() {
        String input = "on off and";

        StopWords stopWords = StopWords.fromWords("the", "a", "on", "off");
        counter = new WordCounterWithStopWordsImpl(stopWords);

        final int countWords = counter.countWords(input);

        assertEquals(1, countWords);
    }

    @Test
    public void when_word_word_word_then_output_is_3() {
        String input = "word word word";

        final int countWords = counter.countWords(input);

        assertEquals(3, countWords);
    }

    @Test
    public void when_word_word_word_no_whitespace_then_output_is_0() {
        String input = "word_word_word";

        final int countWords = counter.countWords(input);

        assertEquals(0, countWords);
    }

    @Test
    public void when_word_word2word_word_then_output_is_2() {
        String input = "word word2word word";

        final int countWords = counter.countWords(input);

        assertEquals(2, countWords);
    }

    @Test
    public void when_special_char_case_then_output_is_2() {
        String input = "word wo!word word.";

        final int countWords = counter.countWords(input);

        assertEquals(1, countWords);
    }

    @Test
    public void when_special_chars_then_output_is_0() {
        String input = "!%";

        final int countWords = counter.countWords(input);

        assertEquals(0, countWords);
    }

    @Test
    public void when_empty_string_then_output_is_0() {
        String input = "";

        final int countWords = counter.countWords(input);

        assertEquals(0, countWords);
    }

    @Test
    public void when_null_then_output_is_0() {
        String input = null;

        final int countWords = counter.countWords(input);

        assertEquals(0, countWords);
    }

}