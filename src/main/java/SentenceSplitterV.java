import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class SentenceSplitterV extends AbstractSentenceSplitter {

    private static final Pattern WORDS_PATTERN = Pattern.compile("([^a-zA-Z\\-])");

    private final List<String> forbiddenWords = new ArrayList<>();


    @Override
    protected String[] splitSentence(final String sentence) {
        final String[] resultSentence = WORDS_PATTERN.split(sentence);

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
