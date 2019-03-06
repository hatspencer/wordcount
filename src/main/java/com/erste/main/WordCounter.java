package com.erste.main;

import java.util.List;

import com.erste.main.util.StopWordFilter;
import com.erste.main.util.StringUtil;

public class WordCounter {

    private List<String> input;
    private List<String> stopWords;

    public WordCounter(List<String> input, List<String> stopWords) {
        this.input = input;
        this.stopWords = stopWords;
    }

    public long countAlphabeticWords() {
        return filterOutStopWords().stream().filter(StringUtil::isAlhabetic).count();
    }

    private List<String> filterOutStopWords() {
        return new StopWordFilter().filterOutStopWords(stopWords, input);
    }
}
