package dto;

import model.TextAnalysis;

public class TextAnalysisResponseDto {
    private final int totalWords;
    private final int totalUniqueWords;

    public TextAnalysisResponseDto(int totalWords, int totalUniqueWords) {
        this.totalWords = totalWords;
        this.totalUniqueWords = totalUniqueWords;
    }

    public TextAnalysisResponseDto(final TextAnalysis textAnalysis) {
        this.totalWords = textAnalysis.getTotalWords();
        this.totalUniqueWords = textAnalysis.getTotalUniqueWords();
    }

    public int getTotalWords() {
        return totalWords;
    }

    public int getTotalUniqueWords() {
        return totalUniqueWords;
    }
}
