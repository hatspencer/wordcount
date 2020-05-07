package word.count.impl;

import java.util.Collection;

import text.split.TextSplitter;
import word.count.WordCounter;
import word.filter.WordFilter;

public class WordCounterImpl implements WordCounter {

    private final Collection<WordFilter> wordFilters;
    private final TextSplitter textSplitter;
    private final String countDescription;

    public WordCounterImpl(Collection<WordFilter> wordFilters, TextSplitter textSplitter, String countDescription) {
        this.wordFilters = wordFilters;
        this.textSplitter = textSplitter;
        this.countDescription = countDescription;
    }

    @Override
    public long count(String text) {
        if (text == null) {
            return 0;
        }

        return textSplitter.split(text).stream()
                .filter(this::matchesAllMatchers)
                .count();
    }

    private boolean matchesAllMatchers(String word) {
        return wordFilters.stream()
                .allMatch(matcher -> matcher.filter(word));
    }

    @Override
    public String getCountDescription() {
        return countDescription;
    }
}
