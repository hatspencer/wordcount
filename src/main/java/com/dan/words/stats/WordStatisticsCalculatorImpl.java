package com.dan.words.stats;

import com.dan.stopwords.StopWords;
import com.dan.words.reader.WordReader;

import java.util.OptionalDouble;

public class WordStatisticsCalculatorImpl implements WordStatisticsCalculator {

    private StopWords stopWords;

    public WordStatisticsCalculatorImpl() {
        this(StopWords.fromFile());
    }

    WordStatisticsCalculatorImpl(StopWords stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public Statistics calculateStatistics(String input) {
        OptionalDouble average = WordReader.readWords(input, stopWords)
                .mapToInt(value -> value.length())
                .average();

        return new Statistics(average.orElse(0.0));
    }
}
