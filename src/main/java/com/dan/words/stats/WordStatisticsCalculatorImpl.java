package com.dan.words.stats;

import com.dan.stopwords.StopWords;
import com.dan.words.reader.WordReader;

import java.util.OptionalDouble;

public class WordStatisticsCalculatorImpl implements WordStatisticsCalculator {

    private String input;
    private StopWords stopWords;

    public WordStatisticsCalculatorImpl(String input) {
        this(input, StopWords.fromFile());
    }

    WordStatisticsCalculatorImpl(String input, StopWords stopWords) {
        this.input = input;
        this.stopWords = stopWords;
    }

    @Override
    public Statistics calculateStatistics() {
        OptionalDouble average = WordReader.readWords(input, stopWords)
                .mapToInt(value -> value.length())
                .average();

        return new Statistics(average.orElse(0.0));
    }
}
