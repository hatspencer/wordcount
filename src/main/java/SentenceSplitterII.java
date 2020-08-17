import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class SentenceSplitterII extends AbstractSentenceSplitter {

    private final List<String> forbiddenWords = new ArrayList<>();

    public WordCounterResult split(final String sentence) {
        if (isInvalidSentence(sentence)) {
            return new WordCounterResult();
        }

        if (forbiddenWords.isEmpty()) {
            readForbiddenWords();
        }

        final String[] resultSentence = splitSentence(sentence);
        final List<String> words = Arrays.stream(resultSentence).filter(it -> !forbiddenWords.contains(it)).collect(Collectors.toList());

        return new WordCounterResult(words);
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
