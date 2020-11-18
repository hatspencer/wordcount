package com.dan.application;

import com.dan.io.InputReader;
import com.dan.wordcounter.WordCounter;
import com.dan.wordcounter.WordCounterWithStopWordsImpl;

public class Application {

    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        String input = inputReader.readInput(args);

        WordCounter counter = new WordCounterWithStopWordsImpl();

        int wordCount = counter.countWords(input);

        System.out.println("Number of words: " + wordCount);
    }

}
