import java.util.regex.Pattern;

public final class SentenceSplitterV extends AbstractSentenceSplitter {

    private static final Pattern WORDS_PATTERN = Pattern.compile("([^a-zA-Z\\-])");

    @Override
    WordCounterResult split(final String sentence) {
        return super.split(sentence);
    }


    @Override
    protected String[] splitSentence(final String sentence) {
        return WORDS_PATTERN.split(sentence);
    }

}
