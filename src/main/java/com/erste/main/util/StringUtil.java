package com.erste.main.util;

import java.util.regex.Pattern;

public class StringUtil {

    private static final Pattern WORD_PATTERN = Pattern.compile("\\p{Alpha}+");

    public static String[] getWhiteSpaceSeparatedWords(String string) {
        return string.split("\\s");
    }

    public static boolean isAlhabetic(String string) {
        return WORD_PATTERN.matcher(string).matches();
    }
}
