package com.erste.main.util;

import java.util.ArrayList;
import java.util.List;

public class StringFilter {

    public List<String> filterOutStrings(List<String> stringsToFilterOut, String... stringsToFilter) {
        List<String> filteredWords = new ArrayList<>();
        for (String word : stringsToFilter) {
            if (StringUtil.isAlhabetic(word) && !stringsToFilterOut.contains(word)) {
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }
}
