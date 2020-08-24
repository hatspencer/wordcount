package at.george.wordcount;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public int countFromFile(final String pathToFile, final String pathToStopWords) {
        final List<String> stopWords = reader.asList(pathToStopWords);
        final String words = reader.asString(pathToFile);
        return (int) Arrays.stream(words.split("\\s"))
                .filter(word -> !Objects.isNull(word))
                .filter(word -> !word.isEmpty())
                .filter(word -> word.matches("^[a-zA-Z]*$"))
                .filter(word -> !stopWords.contains(word))
                .count();
    }
}
