package com.erste.main.util;

import java.util.ArrayList;
import java.util.List;

public class StopWordFilter {

    public List<String> filterOutStopWords(List<String> stopWords, List<String> words) {
        List<String> filteredWords = new ArrayList<>();

        for (String word : words) {
            if (!stopWords.contains(word)) {
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }
}
