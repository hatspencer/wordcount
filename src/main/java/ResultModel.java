public class ResultModel {

    private final Integer totalWordsCount;
    private final Integer uniqueWordsCount;
    private final Double avgWordLength;

    public ResultModel(Integer totalWordsCount, Integer uniqueWordsCount, Double avgWordLength) {
        this.totalWordsCount = totalWordsCount;
        this.uniqueWordsCount = uniqueWordsCount;
        this.avgWordLength = avgWordLength;
    }

    public Integer getTotalWordsCount() {
        return totalWordsCount;
    }

    public Integer getUniqueWordsCount() {
        return uniqueWordsCount;
    }

    public Double getAvgWordLength() {
        return avgWordLength;
    }
}
