package com.dan.words.reader;

import com.dan.stopwords.StopWords;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class WordReader {

    private WordReader() {
        // prevent init
    }

    private static final Pattern pattern = Pattern.compile("[a-zA-Z-]+\\.?");

    public static Stream<String> readWords(String input, StopWords stopWords) {
        Stream<String> wordStream = splitInput(input)
                .map(removeDots());

        return (stopWords != null) ? wordStream.filter(isValidWord(stopWords)) : wordStream;
    }

    static Stream<String> splitInput(String input) {
        if (input == null || input.isEmpty()) {
            return Stream.empty();
        }

        return Arrays.stream(input.split("[\\s]"));
    }

    static Function<String, String> removeDots() {
        return (part -> part.replaceFirst("\\.", ""));
    }

    static Predicate<String> isValidWord(StopWords stopWords) {
        return (word -> !stopWords.contains(word) && isValidWord(word));
    }

    static boolean isValidWord(String word) {
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }

}
