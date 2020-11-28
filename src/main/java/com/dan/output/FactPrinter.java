package com.dan.output;

import com.dan.input.Input;
import com.dan.words.counter.UniqueWordCounterImpl;
import com.dan.words.counter.WordCounter;
import com.dan.words.counter.WordCounterImpl;
import com.dan.words.stats.Statistics;
import com.dan.words.stats.WordStatisticsCalculator;
import com.dan.words.stats.WordStatisticsCalculatorImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FactPrinter implements OutputPrinter {

    private Input input;

    public FactPrinter(Input input) {
        this.input = input;
    }

    @Override
    public void print() {
        int wordCount = getWordCount(input);
        int uniqueWordCount = getUniqueWordCount(input);
        Statistics statistics = getStats(input);
        String averageWordLength = formatAverageWordLength(statistics);

        System.out.println("Number of words: " + wordCount +
                ", unique: " + uniqueWordCount +
                ", average word length: " + averageWordLength + " characters");
    }

    private int getWordCount(Input input) {
        WordCounter counter = new WordCounterImpl(input.getTextContents());
        return counter.countWords();
    }

    private int getUniqueWordCount(Input input) {
        WordCounter uniqueCounter = new UniqueWordCounterImpl(input.getTextContents());
        return uniqueCounter.countWords();
    }

    private Statistics getStats(Input input) {
        WordStatisticsCalculator statsCalculator = new WordStatisticsCalculatorImpl(input.getTextContents());
        return statsCalculator.calculateStatistics();
    }

    private String formatAverageWordLength(Statistics statistics) {
        return BigDecimal.valueOf(statistics.getAverageWordLength())
                .setScale(2, RoundingMode.HALF_UP)
                .toPlainString();
    }

}
