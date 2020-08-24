package at.george.wordcount;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Preparer {

    protected final FileReader reader = new FileReader();

    protected final List<String> stopWords = reader.asList("stopwords.txt");

    protected Stream<String> prepareTheWords(final String input) {
        return Arrays.stream(input.split("\\s"))
                .filter(word -> !Objects.isNull(word))
                .filter(word -> !word.isEmpty())
                .filter(word -> word.matches("^[a-zA-Z]*$"));
    }
}
