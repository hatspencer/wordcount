package at.george.interview.domain.filter;

import at.george.interview.domain.StopWords;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class AlphabeticalWordFilter implements WordFilter {

    private StopWords stopWords;

    public AlphabeticalWordFilter(StopWords stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public List<String> filterWords(String inputText) {

        String[] elements = splitToElements(inputText);

        return Arrays.stream(elements)
                .filter(element -> element.length() > 0)
                .filter(this::isAlphabeticOnly)
                .filter(element -> !stopWords.isStopWord(element))
                .collect(toList());
    }

    private boolean isAlphabeticOnly(String inputElement) {
        return Pattern.matches("[a-zA-Z-]+", inputElement);
    }

    //@VisibleForTesting
    String[] splitToElements(String inputText) {
        return inputText.split("[^a-zA-Z-]");
    }
}
