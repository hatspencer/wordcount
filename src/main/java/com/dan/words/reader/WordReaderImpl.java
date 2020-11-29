package com.dan.words.reader;

import com.dan.stopwords.StopWords;

import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class WordReaderImpl implements WordReader {

    private static final Pattern pattern = Pattern.compile("[a-zA-Z-]+\\.?");

    private StopWords stopWords;

    public WordReaderImpl() {
        this(null);
    }

    public WordReaderImpl(StopWords stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public Stream<String> readWords(String input) {
        return splitInput(input)
                .map(removeDots())
                .filter(word -> !isStopWord(word))
                .filter(word -> isValidWord(word));
    }

    private Stream<String> splitInput(String input) {
        if (input == null || input.isEmpty()) {
            return Stream.empty();
        }

        return Arrays.stream(input.split("[\\s]"));
    }

    private Function<String, String> removeDots() {
        return (word -> word.replaceFirst("\\.", ""));
    }

    private boolean isStopWord(String word) {
        return (stopWords != null) && stopWords.contains(word);
    }

    private boolean isValidWord(String word) {
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }

}
