package model;

public class TextAnalysis {
    private int totalWords;
    private int totalUniqueWords;
    private double averageWordLength;
    private int numberOfUnknownWords;
    private String index;

    public TextAnalysis(
            final int totalWords,
            final int totalUniqueWords,
            final double averageWordLength,
            final String index,
            final int numberOfUnknownWords) {
        this.totalWords = totalWords;
        this.totalUniqueWords = totalUniqueWords;
        this.averageWordLength = averageWordLength;
        this.index = index;
        this.numberOfUnknownWords = numberOfUnknownWords;
    }

    public int getNumberOfUnknownWords() {
        return numberOfUnknownWords;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(final String index) {
        this.index = index;
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
