public class ResultModel {
    private final Integer totalWordsCount;
    private final Integer uniqueWordsCount;

    public ResultModel(Integer totalWordsCount, Integer uniqueWordsCount) {
        this.totalWordsCount = totalWordsCount;
        this.uniqueWordsCount = uniqueWordsCount;
    }

    public Integer getTotalWordsCount() {
        return totalWordsCount;
    }

    public Integer getUniqueWordsCount() {
        return uniqueWordsCount;
    }
}
