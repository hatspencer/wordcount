import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SentenceSplitterII extends AbstractSentenceSplitter {

    private final List<String> forbiddenWords = new ArrayList<>();

    @Override
    protected String[] splitSentence(String sentence) {
        final String[] resultSentence = super.splitSentence(sentence);

        return Arrays.stream(resultSentence).filter(it -> !forbiddenWords.contains(it)).filter(it -> !it.isEmpty()).toArray(String[]::new);
    }

    @Override
    protected void prepareSplitter() {
        if (forbiddenWords.isEmpty()) {
            readForbiddenWords();
        }
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
