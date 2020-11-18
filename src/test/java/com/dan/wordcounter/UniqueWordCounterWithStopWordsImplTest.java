package com.dan.wordcounter;

import com.dan.stopwords.StopWords;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniqueWordCounterWithStopWordsImplTest {

    WordCounter counter = new UniqueWordCounterWithStopWordsImpl(StopWords.fromWords());

    @Test
    public void when_iter_4_input_then_output_is_7() {
        String input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";

        StopWords stopWords = StopWords.fromWords("the", "a", "on", "off");
        counter = new UniqueWordCounterWithStopWordsImpl(stopWords);

        final int countWords = counter.countWords(input);

        assertEquals(7, countWords);
    }

    @Test
    public void when_a_a_a_input_then_output_is_1() {
        String input = "a a a";

        final int countWords = counter.countWords(input);

        assertEquals(1, countWords);
    }

    @Test
    public void when_a_a_dot_a_input_then_output_is_1() {
        String input = "a a. a";

        final int countWords = counter.countWords(input);

        assertEquals(1, countWords);
    }

    @Test
    public void when_a_a_dash_a_a_input_then_output_is_1() {
        String input = "a a-a a";

        final int countWords = counter.countWords(input);

        assertEquals(1, countWords);
    }

    @Test
    public void when_special_char_case_then_output_is_1() {
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