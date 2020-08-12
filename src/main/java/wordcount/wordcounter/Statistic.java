package wordcount.wordcounter;

import java.math.BigDecimal;

public class Statistic {

    private int wordCount;

    private int unique;

    private BigDecimal averageWordLength;

    public Statistic(int wordCount, int unique, BigDecimal averageWordLength) {
        this.wordCount = wordCount;
        this.unique = unique;
        this.averageWordLength = averageWordLength;

    }

    public int getWordCount() {
        return wordCount;
    }

    public int getUnique() {
        return unique;
    }

    public BigDecimal getAverageWordLength() {
        return averageWordLength;
    }
}
