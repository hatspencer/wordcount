package model;

public class TextAnalysis {
    private int totalWords;
    private int totalUniqueWords;

    public TextAnalysis(final int totalWords, final int totalUniqueWords) {
        this.totalWords = totalWords;
        this.totalUniqueWords = totalUniqueWords;
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
