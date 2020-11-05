package at.erste.api;

public class SentenceInformation {

    private Integer words;

    private Integer unique;

    public SentenceInformation(Integer words, Integer unique) {
        this.words = words;
        this.unique = unique;
    }

    public Integer getWords() {
        return words;
    }

    public Integer getUnique() {
        return unique;
    }

}
