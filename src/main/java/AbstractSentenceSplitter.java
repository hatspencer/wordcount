import java.util.Arrays;
import java.util.regex.Pattern;

public abstract class AbstractSentenceSplitter {

    private static final Pattern DEFAULT_WORDS_PATTERN = Pattern.compile("([^a-zA-Z])");


    WordCounterResult split(String sentence) {
        if (isInvalidSentence(sentence)) {
            return new WordCounterResult();
        }

        prepareSplitter();
        final String[] words = splitSentence(sentence);

        return new WordCounterResult(Arrays.asList(words));
    }

    protected void prepareSplitter() {
    }

    protected String[] splitSentence(final String sentence) {
        return DEFAULT_WORDS_PATTERN.split(sentence);
    }

    protected static boolean isInvalidSentence(final String sentence) {
        return sentence == null || sentence.isEmpty();
    }

}
