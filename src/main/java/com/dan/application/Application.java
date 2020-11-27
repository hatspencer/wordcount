package com.dan.application;

import com.dan.input.InputParamReader;
import com.dan.input.InputParamReaderImpl;
import com.dan.words.counter.UniqueWordCounterImpl;
import com.dan.words.counter.WordCounter;
import com.dan.words.counter.WordCounterImpl;
import com.dan.words.stats.Statistics;
import com.dan.words.stats.WordStatisticsCalculator;
import com.dan.words.stats.WordStatisticsCalculatorImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Application {

    public static void main(String[] args) {
        String input = readInput(args);

        WordCounter counter = new WordCounterImpl();
        int wordCount = counter.countWords(input);

        WordCounter uniqueCounter = new UniqueWordCounterImpl();
        int uniqueWordCount = uniqueCounter.countWords(input);

        WordStatisticsCalculator statsCalculator = new WordStatisticsCalculatorImpl();
        Statistics statistics = statsCalculator.calculateStatistics(input);

        printOutput(wordCount, uniqueWordCount, statistics);
    }

    private static String readInput(String[] args) {
        InputParamReader inputReader = new InputParamReaderImpl();
        String input = inputReader.readInput(args);
        return input;
    }

    private static void printOutput(int wordCount, int uniqueWordCount, Statistics statistics) {
        String averageWordLength = BigDecimal.valueOf(statistics.getAverageWordLength())
                .setScale(2, RoundingMode.HALF_UP)
                .toPlainString();

        System.out.println("Number of words: " + wordCount +
                ", unique: " + uniqueWordCount +
                ", average word length: " + averageWordLength + " characters");
    }

}
