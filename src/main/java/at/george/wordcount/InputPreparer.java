package at.george.wordcount;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class InputPreparer {

    private final List<String> stopWords;

    public InputPreparer(final List<String> stopWords) {
        this.stopWords = stopWords;
    }

    protected Stream<String> splitAndCleanInput(final String input) {
//        splitting regex must be changed to accommodate the - splitting the words
        return Arrays.stream(input.split("[- |\\\\s]"))
                .filter(word -> !Objects.isNull(word))
                .filter(word -> !word.isEmpty())
                .filter(word -> word.matches("^[a-zA-Z]*$"))
                .filter(filterOutStopWords());
    }

    private Predicate<String> filterOutStopWords() {
        return word -> !stopWords.contains(word);
    }
}
