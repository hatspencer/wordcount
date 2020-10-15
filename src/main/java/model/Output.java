package model;

/**
 * Created by Marton Bartal on 15.10.2020.
 */
public class Output {
    private int wordCount;
    private int uniqueWordCount;
    private double avgWordLength;

    public Output() {
    }

    public Output(int wordCount, int uniqueWordCount, double avgWordLength) {
        this.wordCount = wordCount;
        this.uniqueWordCount = uniqueWordCount;
        this.avgWordLength = avgWordLength;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setUniqueWordCount(int uniqueWordCount) {
        this.uniqueWordCount = uniqueWordCount;
    }

    public int getUniqueWordCount() {
        return uniqueWordCount;
    }

    public double getAvgWordLength() {
        return avgWordLength;
    }

    public void setAvgWordLength(double avgWordLength) {
        this.avgWordLength = avgWordLength;
    }

    @Override
    public String toString() {
        return new StringBuilder().
                append("Number of words: ").
                append(wordCount).
                append(", unique: ").
                append(uniqueWordCount).
                append("; average word length: ").
                append(avgWordLength).
                append(" characters").toString();
    }
}
