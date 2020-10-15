package model;

/**
 * Created by Marton Bartal on 15.10.2020.
 */
public class Output {
    private int wordCount;
    private int uniqueWordCount;

    public Output() {
    }

    public Output(int wordCount, int uniqueWordCount) {
        this.wordCount = wordCount;
        this.uniqueWordCount = uniqueWordCount;
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

    @Override
    public String toString() {
        return new StringBuilder().
                append("Number of words: ").
                append(wordCount).
                append(", unique").
                append(getUniqueWordCount()).toString();
    }
}
