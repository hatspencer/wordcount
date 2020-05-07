package word.count.impl;

import java.util.Collection;

import text.split.TextSplitter;
import word.count.WordCounter;
import word.filter.WordFilter;

public class UniqueWordCounterImpl implements WordCounter {

    private final Collection<WordFilter> wordFilters;
    private final TextSplitter textSplitter;

    public UniqueWordCounterImpl(Collection<WordFilter> wordFilters, TextSplitter textSplitter) {
        this.wordFilters = wordFilters;
        this.textSplitter = textSplitter;
    }

    @Override
    public long count(String text) {
        if (text == null) {
            return 0;
        }

        return textSplitter.split(text).stream()
                .filter(this::matchesAllMatchers)
                .distinct()
                .count();
    }

    private boolean matchesAllMatchers(String word) {
        return wordFilters.stream()
                .allMatch(matcher -> matcher.filter(word));
    }
}
