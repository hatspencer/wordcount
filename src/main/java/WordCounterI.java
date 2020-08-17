public final class WordCounterI extends AbstractWordCounter {

    public WordCounterResult count(final String sentence) {
        if (isInvalidSentence(sentence)) {
            return new WordCounterResult(0);
        }

        final int wordsCount = splitSentence(sentence).length;

        return new WordCounterResult(wordsCount);
    }

}
