package com.dan.words.stats;

import com.dan.stopwords.StopWords;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordStatisticsCalculatorImplTest {

    WordStatisticsCalculatorImpl calculator = new WordStatisticsCalculatorImpl(StopWords.fromWords("c"));

    @Test
    public void when_word_then_returns_1() {
        String input = "word";

        Statistics statistics = calculator.calculateStatistics(input);

        assertEquals(4.0, statistics.getAverageWordLength(), 0.001);
    }

    @Test
    public void when_ab_ab_ab_then_returns_2() {
        String input = "ab ab ab";

        Statistics statistics = calculator.calculateStatistics(input);

        assertEquals(2.0, statistics.getAverageWordLength(), 0.001);
    }

    @Test
    public void when_ab_ba_c_then_returns_2() {
        String input = "ab ba c";

        Statistics statistics = calculator.calculateStatistics(input);

        assertEquals(2.0, statistics.getAverageWordLength(), 0.001);
    }

    @Test
    public void when_not_equal_word_lengths_then_returns_475() {
        String input = "not equal word lengths";

        Statistics statistics = calculator.calculateStatistics(input);

        assertEquals(4.75, statistics.getAverageWordLength(), 0.001);
    }

    @Test
    public void when_blank_string_then_returns_0() {
        String input = "   ";

        Statistics statistics = calculator.calculateStatistics(input);

        assertEquals(0, statistics.getAverageWordLength(), 0.001);
    }

    @Test
    public void when_empty_string_then_returns_0() {
        String input = "";

        Statistics statistics = calculator.calculateStatistics(input);

        assertEquals(0, statistics.getAverageWordLength(), 0.001);
    }

    @Test
    public void when_null_then_returns_0() {
        String input = null;

        Statistics statistics = calculator.calculateStatistics(input);

        assertEquals(0, statistics.getAverageWordLength(), 0.001);
    }

}