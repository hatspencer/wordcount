package bencody;

import java.util.List;

public class WordCountStatistics {

    public final int totalCount;
    public final long uniqueCount;
    public final double averageWordLength; // of all words, not just unique words.
    public final List<String> wordIndex;

    public WordCountStatistics(int totalCount, long uniqueCount, double averageWordLength, List<String> wordIndex) {
        this.totalCount = totalCount;
        this.uniqueCount = uniqueCount;
        this.averageWordLength = averageWordLength;
        this.wordIndex = wordIndex;
    }
}
