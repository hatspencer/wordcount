package com.dan.words.counter;

import com.dan.stopwords.StopWords;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniqueWordCounterImplTest {

    UniqueWordCounterImpl counter = new UniqueWordCounterImpl(StopWords.fromWords("the", "a", "on", "off"));

    @Test
    public void when_iter_4_input_then_output_is_6() {
        String input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";

        final int countWords = counter.countWords(input);

        assertEquals(6, countWords);
    }

    @Test
    public void when_a_a_a_input_then_output_is_1() {
        String input = "b b b";

        final int countWords = counter.countWords(input);

        assertEquals(1, countWords);
    }

    @Test
    public void when_b_b_dot_b_input_then_output_is_1() {
        String input = "b b. b";

        final int countWords = counter.countWords(input);

        assertEquals(1, countWords);
    }

    @Test
    public void when_b_b_dash_b_b_input_then_output_is_2() {
        String input = "b b-b b";

        final int countWords = counter.countWords(input);

        assertEquals(2, countWords);
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