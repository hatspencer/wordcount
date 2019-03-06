package com.erste.main.util;

import java.util.regex.Pattern;

public class StringUtil {

    private static final Pattern WORD_PATTERN = Pattern.compile("\\p{Alpha}+");

    public static int getWordCountInString(String s) {
        int wordCount = 0;
        String[] splitString = s.split("\\s");

        for (String string : splitString) {
            if (WORD_PATTERN.matcher(string).matches()) {
                wordCount++;
            }
        }

        return wordCount;
    }

    public static boolean isAlhabetic(String string) {
        return WORD_PATTERN.matcher(string).matches();
    }
}
