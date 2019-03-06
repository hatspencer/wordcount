package com.erste.main.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringUtil {

    private static final Pattern WORD_PATTERN = Pattern.compile("\\p{Alpha}+");

    public static List<String> getWhiteSpaceSeparatedWordsAsList(String string) {
        return Arrays.asList(string.split("\\s"));
    }

    public static boolean isAlhabetic(String string) {
        return WORD_PATTERN.matcher(string).matches();
    }
}
