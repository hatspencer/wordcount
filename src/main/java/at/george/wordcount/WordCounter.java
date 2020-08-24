package at.george.wordcount;

import java.util.Arrays;
import java.util.List;

public class WordCounter {

    private FileReader reader = new FileReader();
    public int count(final String input) {
        return (int) Arrays.stream(input.split("\\s"))
                .filter(word -> !word.isEmpty())
                .filter(word -> word.matches("^[a-zA-Z]*$"))
                .count();
    }

    public int count(final String input, final String pathToStopWords) {
        final List<String> stopWords = reader.asList(pathToStopWords);
        return (int) Arrays.stream(input.split("\\s"))
                .filter(word -> !word.isEmpty())
                .filter(word -> word.matches("^[a-zA-Z]*$"))
                .filter(word -> !stopWords.contains(word))
                .count();
    }
}
