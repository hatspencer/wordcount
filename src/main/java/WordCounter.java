import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class WordCounter {

    private final static Pattern WORDS_PATTERN = Pattern.compile("([^a-zA-Z])");

    private final List<String> forbiddenWords = new ArrayList<>();

    public int count(final String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }

        return WORDS_PATTERN.split(sentence).length;
    }

    public int count2(final String sentence) {
        return 0;
    }

}
