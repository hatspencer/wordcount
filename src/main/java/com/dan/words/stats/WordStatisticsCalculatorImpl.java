package com.dan.words.stats;

import com.dan.stopwords.StopWords;
import com.dan.words.reader.WordReader;
import com.dan.words.reader.WordReaderImpl;

import java.util.OptionalDouble;

public class WordStatisticsCalculatorImpl implements WordStatisticsCalculator {

    private String input;
    private WordReader wordReader;

    public WordStatisticsCalculatorImpl(String input) {
        this(input, StopWords.fromFile());
    }

    WordStatisticsCalculatorImpl(String input, StopWords stopWords) {
        this.input = input;
        this.wordReader = new WordReaderImpl(stopWords);
    }

    @Override
    public Statistics calculateStatistics() {
        OptionalDouble average = wordReader.readWords(input)
                .mapToInt(value -> value.length())
                .average();

        return new Statistics(average.orElse(0.0));
    }
}
