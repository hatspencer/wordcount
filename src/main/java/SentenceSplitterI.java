import java.util.Arrays;

public final class SentenceSplitterI extends AbstractSentenceSplitter {

    public WordCounterResult split(final String sentence) {
        if (isInvalidSentence(sentence)) {
            return new WordCounterResult();
        }

        final String[] words = splitSentence(sentence);

        return new WordCounterResult(Arrays.asList(words));
    }

}
