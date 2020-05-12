package at.george.interview.domain.unique;

import at.george.interview.domain.UniquenessCalculator;
import at.george.interview.domain.WordFilter;

public class AlphabeticUniquenessCalculator implements UniquenessCalculator {

    private WordFilter wordFilter;

    public AlphabeticUniquenessCalculator(WordFilter wordFilter) {
        this.wordFilter = wordFilter;
    }

    @Override
    public long getUniqueWords(String inputText) {

        return wordFilter.filterWords(inputText).stream().distinct().count();
    }
}
