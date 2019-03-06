package com.erste.main;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.erste.main.util.StopWordFilter;
import com.erste.main.util.StringUtil;

public class WordCounter {

    private List<String> input;
    private List<String> stopWords;

    private List<String> alphabeticWords;

    public WordCounter(List<String> input, List<String> stopWords) {
        this.input = input;
        this.stopWords = stopWords;
    }

    public long countAlphabeticWords() {
        return filterAlphabeticWords().size();
    }

    public long countUniqueWords() {
        return new HashSet<>(filterAlphabeticWords()).size();
    }

    private List<String> filterAlphabeticWords() {
        if (alphabeticWords == null) {
            alphabeticWords = filterOutStopWords().stream().filter(StringUtil::isAlhabetic).collect(Collectors.toList());
        }
        return alphabeticWords;
    }

    private List<String> filterOutStopWords() {
        return new StopWordFilter().filterOutStopWords(stopWords, input);
    }
}
