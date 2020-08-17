import java.util.regex.Pattern;

public abstract class AbstractWordCounter {

    private static final Pattern WORDS_PATTERN = Pattern.compile("([^a-zA-Z])");


    abstract WordCounterResult count(String sentence);

    protected static String[] splitSentence(final String sentence) {
        return WORDS_PATTERN.split(sentence);
    }

    protected static boolean isInvalidSentence(final String sentence) {
        return sentence == null || sentence.isEmpty();
    }

}
