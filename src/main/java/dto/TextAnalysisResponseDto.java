package dto;

public class TextAnalysisResponseDto {
    private final int totalCount;
    private final int totalUnique;

    public TextAnalysisResponseDto(int totalCount, int totalUnique) {
        this.totalCount = totalCount;
        this.totalUnique = totalUnique;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getTotalUnique() {
        return totalUnique;
    }
}
