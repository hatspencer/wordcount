package at.george.wordcount;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class WordCounter {

    private final InputPreparer inputPreparer;

    public WordCounter(final InputPreparer inputPreparer) {
        this.inputPreparer = inputPreparer;
    }

    public int count(final String input) {
        final Stream<String> preparedInput = inputPreparer.splitAndCleanInput(input);
//        needs to be moved elsewhere
        final List<String> allFilteredWords = preparedInput.collect(toList());
        final Set<String> uniqueWords = new HashSet<>(allFilteredWords);

        return allFilteredWords.size();
    }
}
