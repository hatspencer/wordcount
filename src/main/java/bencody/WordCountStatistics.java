package bencody;

import java.util.Optional;

public class WordCountStatistics {

    public final int totalCount;
    public final long uniqueCount;
    public final double averageWordLength; // of all words, not just unique words.
    public final Optional<WordIndex> wordIndex;

    public WordCountStatistics(int totalCount, long uniqueCount, double averageWordLength, Optional<WordIndex> wordIndex) {
        this.totalCount = totalCount;
        this.uniqueCount = uniqueCount;
        this.averageWordLength = averageWordLength;
        this.wordIndex = wordIndex;
    }
}
