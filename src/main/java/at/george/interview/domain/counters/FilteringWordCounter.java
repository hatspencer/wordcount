package at.george.interview.domain.counters;

import at.george.interview.domain.filter.WordFilter;

public class FilteringWordCounter implements WordCounter {

    private WordFilter wordFilter;

    public FilteringWordCounter(WordFilter wordFilter) {
        this.wordFilter = wordFilter;
    }

    @Override
    public long countWords(String inputText) {
        return wordFilter.filterWords(inputText).size();
    }
}
