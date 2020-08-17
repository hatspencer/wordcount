import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class WordCounterII extends AbstractWordCounter {

    private final List<String> forbiddenWords = new ArrayList<>();

    public WordCounterResult count(final String sentence) {
        if (isInvalidSentence(sentence)) {
            return new WordCounterResult(0);
        }

        if (forbiddenWords.isEmpty()) {
            readForbiddenWords();
        }

        final String[] resultSentence = splitSentence(sentence);

        final long wordsCount = Arrays.stream(resultSentence).filter(it -> !forbiddenWords.contains(it)).count();

        return new WordCounterResult(wordsCount);
    }

    private void readForbiddenWords() {
        final String fileName = "src/main/resources/stopwords.txt";

        try {
            final Path stopWordFile = Paths.get(fileName);
            final List<String> lines = Files.readAllLines(stopWordFile, StandardCharsets.UTF_8);

            forbiddenWords.clear();
            forbiddenWords.addAll(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
