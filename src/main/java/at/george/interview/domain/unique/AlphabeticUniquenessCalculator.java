package at.george.interview.domain.unique;

import at.george.interview.domain.StopWords;
import at.george.interview.domain.UniquenessCalculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class AlphabeticUniquenessCalculator implements UniquenessCalculator {

    private StopWords stopWords;

    public AlphabeticUniquenessCalculator(StopWords stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public long getUniqueWords(String inputText) {
        String[] elements = splitToElements(inputText);

        return Arrays.stream(elements)
                .filter(element -> element.length() > 0)
                .filter(this::isAlphabeticOnly)
                .filter(element -> !stopWords.isStopWord(element))
                .distinct()
                .count();
    }

    private boolean isAlphabeticOnly(String inputElement) {
        return Pattern.matches("[a-zA-Z]+", inputElement);
    }

    //@VisibleForTesting
    String[] splitToElements(String inputText) {
        return inputText.split("[^a-zA-Z]");
    }

}
