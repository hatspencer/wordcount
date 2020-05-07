package word.count.impl;

import text.split.TextSplitter;
import word.count.WordCounter;
import word.match.WordMatcher;

public class WordCounterImpl implements WordCounter {

    private final WordMatcher wordMatcher;
    private final TextSplitter textSplitter;

    public WordCounterImpl(WordMatcher wordMatcher, TextSplitter textSplitter) {
        this.wordMatcher = wordMatcher;
        this.textSplitter = textSplitter;
    }

    @Override
    public long count(String text) {
        if (text == null) {
            return 0;
        }

        return textSplitter.split(text).stream()
                .filter(wordMatcher::match)
                .count();
    }
}
