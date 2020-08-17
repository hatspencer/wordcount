import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class WordCounter {

    private static final Pattern WORDS_PATTERN = Pattern.compile("([^a-zA-Z])");
    private static final String STOPWORDS_FILE_NAME = "stopwords.txt";

    private final List<String> forbiddenWords = new ArrayList<>();

    public int count(final String sentence) {
        if (isInvalidSentence(sentence)) {
            return 0;
        }

        return splitSentence(sentence).length;
    }

    public long count2(final String sentence) {
        if (isInvalidSentence(sentence)) {
            return 0;
        }

        if (forbiddenWords.isEmpty()) {
            readForbiddenWords();
        }

        final String[] resultSentence = splitSentence(sentence);

        return Arrays.stream(resultSentence).filter(it -> !forbiddenWords.contains(it)).count();
    }

    private void readForbiddenWords() {
        final URL resourceURL = WordCounter.class.getResource(STOPWORDS_FILE_NAME);

        try {
            final Path stopWordFile = Paths.get(resourceURL.toURI());
            final List<String> lines = Files.readAllLines(stopWordFile, StandardCharsets.UTF_8);

            forbiddenWords.clear();
            forbiddenWords.addAll(lines);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

    }

    private static String[] splitSentence(final String sentence) {
        return WORDS_PATTERN.split(sentence);
    }

    private static boolean isInvalidSentence(final String sentence) {
        return sentence == null || sentence.isEmpty();
    }

}
