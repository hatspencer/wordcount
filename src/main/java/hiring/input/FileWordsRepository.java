package hiring.input;

import hiring.WordsRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileWordsRepository implements WordsRepository {

    private final Set<String> words;

    public FileWordsRepository(Path filePath) {
        this.words = loadWords(filePath);
    }

    private Set<String> loadWords(Path filePath) {
        try {
            List<String> lines = Files.readAllLines(filePath);
            return new HashSet<>(lines);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean containsWord(String word) {
        return words.contains(word);
    }
}
