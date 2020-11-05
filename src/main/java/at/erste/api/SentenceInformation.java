package at.erste.api;

public class SentenceInformation {

    private Integer words;

    private Integer unique;

    private Double average;

    public SentenceInformation(Integer words, Integer unique, Double average) {
        this.words = words;
        this.unique = unique;
        this.average = average;
    }

    public Integer getWords() {
        return words;
    }

    public Integer getUnique() {
        return unique;
    }

    public Double getAverage() {
        return average;
    }
}
