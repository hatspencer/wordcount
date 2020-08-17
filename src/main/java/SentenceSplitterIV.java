public final class SentenceSplitterIV extends AbstractSentenceSplitter {

    private final SentenceSplitterII wc2 = new SentenceSplitterII();

    @Override
    WordCounterResult split(final String sentence) {
        final WordCounterResult wordCount = wc2.split(sentence);


        return new WordCounterResult(wordCount.getCount(), 0);
    }

}
