package dto;

import model.TextAnalysis;

public class TextAnalysisResponseDto {
    private final int totalWords;
    private final int totalUniqueWords;
    private final double averageWordLength;
    private final String index;

    public TextAnalysisResponseDto(final TextAnalysis textAnalysis) {
        this.totalWords = textAnalysis.getTotalWords();
        this.totalUniqueWords = textAnalysis.getTotalUniqueWords();
        this.averageWordLength = textAnalysis.getAverageWordLength();
        this.index = textAnalysis.getIndex();
    }

    public int getTotalWords() {
        return totalWords;
    }

    public int getTotalUniqueWords() {
        return totalUniqueWords;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    public String toString() {
        return String.format("Number of words: %d, unique: %d, average word length: %f", totalWords, totalUniqueWords, averageWordLength);
    }

    public String toStringWithIndex() {
        return String.format("Number of words: %d, unique: %d, average word length: %f. \nIndex:\n%s", totalWords, totalUniqueWords, averageWordLength, index);
    }
}
