public class ResultModel {

    private final Integer totalWordsCount;
    private final Integer uniqueWordsCount;
    private final String avgWordLength;

    public ResultModel(Integer totalWordsCount, Integer uniqueWordsCount, String avgWordLength) {
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

    public String getAvgWordLength() {
        return avgWordLength;
    }
}
