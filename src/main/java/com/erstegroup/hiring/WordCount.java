package com.erstegroup.hiring;

import java.util.Arrays;
import java.util.List;

public class WordCount {

    private WordCount() {
    }

    public static long wordCount(String text, final List<String> stopWords) {
        String[] words = text.split("[ ]+");
        return Arrays.asList(words).stream().filter(word -> !stopWords.contains(word)).count();
    }
}
