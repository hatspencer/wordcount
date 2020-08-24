package at.george.wordcount;

import java.util.stream.Stream;

public class WordCounter {

    private final InputPreparer inputPreparer;

    public WordCounter(final InputPreparer inputPreparer) {
        this.inputPreparer = inputPreparer;
    }

    public int count(final String input) {
        final Stream<String> preparedInput = inputPreparer.splitAndCleanInput(input);
        return (int) preparedInput.count();
    }
}
