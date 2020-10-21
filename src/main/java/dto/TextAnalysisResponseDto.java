package dto;

import model.TextAnalysis;

public class TextAnalysisResponseDto {
    private final int totalWords;
    private final int totalUniqueWords;
    private final double averageWordLength;

    public TextAnalysisResponseDto(final TextAnalysis textAnalysis) {
        this.totalWords = textAnalysis.getTotalWords();
        this.totalUniqueWords = textAnalysis.getTotalUniqueWords();
        this.averageWordLength = textAnalysis.getAverageWordLength();
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
}
