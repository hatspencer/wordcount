package model;

public class TextAnalysis {
    private int totalWords;
    private int totalUniqueWords;
    private double averageWordLength;

    public TextAnalysis(final int totalWords, final int totalUniqueWords, final double averageWordLength) {
        this.totalWords = totalWords;
        this.totalUniqueWords = totalUniqueWords;
        this.averageWordLength = averageWordLength;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    public void setAverageWordLength(final double averageWordLength) {
        this.averageWordLength = averageWordLength;
    }

    public int getTotalWords() {
        return totalWords;
    }

    public void setTotalWords(final int totalWords) {
        this.totalWords = totalWords;
    }

    public int getTotalUniqueWords() {
        return totalUniqueWords;
    }

    public void setTotalUniqueWords(final int totalUniqueWords) {
        this.totalUniqueWords = totalUniqueWords;
    }
}
