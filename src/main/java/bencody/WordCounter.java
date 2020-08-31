package bencody;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {

    private final Pattern wordRegexp = Pattern.compile("([a-zA-Z-]+)");
    private final List<String> stopWords;

    public WordCounter(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public WordCountStatistics countWords(String text) {
        return countWords(text, false);
    }

    public WordCountStatistics countWords(String text, boolean outputIndex) {
        Matcher matcher = wordRegexp.matcher(text);
        return countMatches(matcher, outputIndex);
    }

    private WordCountStatistics countMatches(Matcher matcher, boolean outputIndex) {
        final List<String> allWords = new ArrayList<>();
        while (matcher.find()) {
            String word = matcher.group();
            if (!stopWords.contains(word)) {
                allWords.add(word);
            }
        }

        List<String> index = Collections.emptyList();
        if (outputIndex) {
            index = allWords.stream()
                    .sorted(Collator.getInstance())
                    .collect(Collectors.toList());
        }

        final List<String> uniqueWords = allWords.stream()
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());

        double averageWordLength = allWords.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0d);

        return new WordCountStatistics(allWords.size(), uniqueWords.size(), averageWordLength, index);
    }
}
