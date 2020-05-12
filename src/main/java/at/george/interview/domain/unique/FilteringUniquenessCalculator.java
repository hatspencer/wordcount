package at.george.interview.domain.unique;

import at.george.interview.domain.filter.WordFilter;

public class FilteringUniquenessCalculator implements UniquenessCalculator {

    private WordFilter wordFilter;

    public FilteringUniquenessCalculator(WordFilter wordFilter) {
        this.wordFilter = wordFilter;
    }

    @Override
    public long countUniqueWords(String inputText) {

        return wordFilter.filterWords(inputText).stream().distinct().count();
    }
}
