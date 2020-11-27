package com.dan.application;

import com.dan.input.InputParamReader;
import com.dan.input.InputParamReaderImpl;
import com.dan.words.counter.UniqueWordCounterImpl;
import com.dan.words.counter.WordCounter;
import com.dan.words.counter.WordCounterImpl;

public class Application {

    public static void main(String[] args) {
        InputParamReader inputReader = new InputParamReaderImpl();
        String input = inputReader.readInput(args);

        WordCounter counter = new WordCounterImpl();
        int wordCount = counter.countWords(input);

        WordCounter uniqueCounter = new UniqueWordCounterImpl();
        int uniqueWordCount = uniqueCounter.countWords(input);

        System.out.println("Number of words: " + wordCount + ", unique: " + uniqueWordCount);
    }

}
