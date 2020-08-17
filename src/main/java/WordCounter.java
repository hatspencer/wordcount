import java.util.regex.Pattern;

public final class WordCounter {

    private final static Pattern WORDS_PATTERN = Pattern.compile("([^a-zA-Z])");

    public int count(final String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }

        return WORDS_PATTERN.split(sentence).length;
    }

}
