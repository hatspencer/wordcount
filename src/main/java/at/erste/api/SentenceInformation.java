package at.erste.api;

import java.util.Set;

public class SentenceInformation {

    private Integer words;

    private Integer unique;

    private Double average;

    private Set<String> countedWords;

    public SentenceInformation(Integer words, Integer unique, Double average, Set<String> countedWords) {
        this.words = words;
        this.unique = unique;
        this.average = average;
        this.countedWords = countedWords;
    }

    public Set<String> getCountedWords() {
        return countedWords;
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
