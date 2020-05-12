package at.george.interview.domain.counters;

import at.george.interview.domain.WordCounter;
import at.george.interview.domain.WordFilter;

public class AlphabeticWordCounter implements WordCounter {

    private WordFilter wordFilter;

    public AlphabeticWordCounter(WordFilter wordFilter) {
        this.wordFilter = wordFilter;
    }

    @Override
    public long countWords(String inputText) {
        return wordFilter.filterWords(inputText).size();
    }
}
