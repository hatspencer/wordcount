public final class SentenceSplitterIV extends AbstractSentenceSplitter {

    private final SentenceSplitterII wc2 = new SentenceSplitterII();

    @Override
    WordCounterResult split(final String sentence) {
        return wc2.split(sentence);
    }

}
