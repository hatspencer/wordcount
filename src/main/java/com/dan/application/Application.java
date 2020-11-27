package com.dan.application;

import com.dan.input.Input;
import com.dan.input.InputParamReader;
import com.dan.input.InputParamReaderImpl;
import com.dan.words.counter.UniqueWordCounterImpl;
import com.dan.words.counter.WordCounter;
import com.dan.words.counter.WordCounterImpl;
import com.dan.words.index.WordIndexCreator;
import com.dan.words.index.WordIndexCreatorImpl;
import com.dan.words.stats.Statistics;
import com.dan.words.stats.WordStatisticsCalculator;
import com.dan.words.stats.WordStatisticsCalculatorImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Input input = readInput(args);

        int wordCount = getWordCount(input);
        int uniqueWordCount = getUniqueWordCount(input);
        Statistics statistics = getStats(input);

        printFacts(wordCount, uniqueWordCount, statistics);

        List<String> index = getIndex(input);

        printIndex(index);
    }

    private static Input readInput(String[] args) {
        InputParamReader inputReader = new InputParamReaderImpl();
        return inputReader.readInput(args);
    }

    private static int getWordCount(Input input) {
        WordCounter counter = new WordCounterImpl();
        return counter.countWords(input.getText());
    }

    private static int getUniqueWordCount(Input input) {
        WordCounter uniqueCounter = new UniqueWordCounterImpl();
        return uniqueCounter.countWords(input.getText());
    }

    private static Statistics getStats(Input input) {
        WordStatisticsCalculator statsCalculator = new WordStatisticsCalculatorImpl();
        return statsCalculator.calculateStatistics(input.getText());
    }

    private static List<String> getIndex(Input input) {
        WordIndexCreator indexCreator = new WordIndexCreatorImpl();
        return indexCreator.createIndex(input.getText());
    }

    private static void printFacts(int wordCount, int uniqueWordCount, Statistics statistics) {
        String averageWordLength = BigDecimal.valueOf(statistics.getAverageWordLength())
                .setScale(2, RoundingMode.HALF_UP)
                .toPlainString();

        System.out.println("Number of words: " + wordCount +
                ", unique: " + uniqueWordCount +
                ", average word length: " + averageWordLength + " characters");
    }

    private static void printIndex(List<String> index) {
        System.out.println("Index:");
        for (String word : index) {
            System.out.println(word);
        }
    }

}
