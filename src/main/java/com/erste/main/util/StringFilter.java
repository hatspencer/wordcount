package com.erste.main.util;

import java.util.ArrayList;
import java.util.List;

public class StringFilter {

    public List<String> filterOutStrings(List<String> stopWords, String[] words) {
        List<String> filteredWords = new ArrayList<>();

        for (String word : words) {
            if (StringUtil.isAlhabetic(word) && !stopWords.contains(word)) {
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }
}
