package hiring.input;

import hiring.WordsRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

public class ResourceWordsRepository implements WordsRepository {

    private final Set<String> words;

    public ResourceWordsRepository(String resource) {
        this.words = loadWords(resource);
    }

    private Set<String> loadWords(String resource) {
        try (BufferedReader reader = openReader(resource)) {
            return reader.lines().collect(Collectors.toSet());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private BufferedReader openReader(String resource) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resource);
        if (inputStream == null) {
            throw new IllegalArgumentException("Resource " + resource + " does not exist!");
        }
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public boolean containsWord(String word) {
        return words.contains(word);
    }
}
