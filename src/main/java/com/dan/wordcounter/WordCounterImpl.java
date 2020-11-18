package com.dan.wordcounter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounterImpl implements WordCounter {

    @Override
    public int countWords(String input) {
        if (input == null) return 0;

        final String[] parts = input.split("\\s");
        final Pattern pattern = Pattern.compile("[a-zA-Z]+");

        int wordCount = 0;
        for (String part : parts) {
            Matcher matcher = pattern.matcher(part);

            if (matcher.matches()) wordCount++;
        }

        return wordCount;
    }

}
