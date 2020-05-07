package word.count.impl;

import java.util.Collection;

import text.split.TextSplitter;
import word.count.WordCounter;
import word.filter.WordFilter;
import word.map.WordMapper;

public class WordCounterImpl implements WordCounter {

    private final Collection<WordFilter> wordFilters;
    private final Collection<WordMapper> wordMappers;
    private final TextSplitter textSplitter;
    private final String countDescription;

    public WordCounterImpl(Collection<WordFilter> wordFilters, Collection<WordMapper> wordMappers, TextSplitter textSplitter, String countDescription) {
        this.wordFilters = wordFilters;
        this.wordMappers = wordMappers;
        this.textSplitter = textSplitter;
        this.countDescription = countDescription;
    }

    @Override
    public long count(String text) {
        if (text == null) {
            return 0;
        }

        return textSplitter.split(text).stream()
                .map(this::useAllMappers)
                .filter(this::matchesAllMatchers)
                .count();
    }

    private boolean matchesAllMatchers(String word) {
        return wordFilters.stream()
                .allMatch(matcher -> matcher.filter(word));
    }

    private String useAllMappers(String word) {
        String mappedString = word;
        for(WordMapper wordMapper: wordMappers) {
            mappedString = wordMapper.map(word);
        }

        return mappedString;
    }

    @Override
    public String getCountDescription() {
        return countDescription;
    }
}
