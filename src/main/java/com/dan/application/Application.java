package com.dan.application;

import com.dan.input.InputParamReader;
import com.dan.input.InputParamReaderImpl;
import com.dan.wordcounter.WordCounter;
import com.dan.wordcounter.WordCounterWithStopWordsImpl;

public class Application {

    public static void main(String[] args) {
        InputParamReader inputReader = new InputParamReaderImpl();
        String input = inputReader.readInput(args);

        WordCounter counter = new WordCounterWithStopWordsImpl();
        int wordCount = counter.countWords(input);

        System.out.println("Number of words: " + wordCount);
    }

}
