import java.io.IOException;
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

    private final List<String> forbiddenWords = new ArrayList<>();

    public WordCounterResult count(final String sentence) {
        if (isInvalidSentence(sentence)) {
            return new WordCounterResult(0);
        }

        final int wordsCount = splitSentence(sentence).length;

        return new WordCounterResult(wordsCount);
    }

    public WordCounterResult count2(final String sentence) {
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

    public long count4(final String sentence) {
        return 0;
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

    private static String[] splitSentence(final String sentence) {
        return WORDS_PATTERN.split(sentence);
    }

    private static boolean isInvalidSentence(final String sentence) {
        return sentence == null || sentence.isEmpty();
    }

}
