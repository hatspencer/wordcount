public final class SentenceSplitterI extends AbstractSentenceSplitter {

    public WordCounterResult split(final String sentence) {
        if (isInvalidSentence(sentence)) {
            return new WordCounterResult(0);
        }

        final int wordsCount = splitSentence(sentence).length;

        return new WordCounterResult(wordsCount);
    }

}
