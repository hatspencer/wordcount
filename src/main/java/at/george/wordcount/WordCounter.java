package at.george.wordcount;

import java.util.Arrays;

public class WordCounter {

    public int count(final String input) {
        return (int) Arrays.stream(input.split("\\s"))
                .filter(word -> !word.isEmpty())
                .filter(word -> word.matches("^[a-zA-Z]*$"))
                .count();
    }
}
