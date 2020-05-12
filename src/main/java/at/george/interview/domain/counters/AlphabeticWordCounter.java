package at.george.interview.domain.counters;

import at.george.interview.domain.StopWords;
import at.george.interview.domain.WordCounter;

import java.util.Arrays;
import java.util.regex.Pattern;

public class AlphabeticWordCounter implements WordCounter {

    private StopWords stopWords;

    public AlphabeticWordCounter(StopWords stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public long countWords(String inputText) {

        String[] elements = splitToElements(inputText);

        long count = Arrays.stream(elements)
                .filter(element -> element.length() > 0)
                .filter(this::isAlphabeticOnly)
                .filter(element -> !stopWords.isStopWord(element))
                .count();

        return count;
    }

    private boolean isAlphabeticOnly(String inputElement) {
        return Pattern.matches("[a-zA-Z]+", inputElement);
    }

    private String[] splitToElements(String inputText) {
        return inputText.split("\\s");
    }

}
