package model;

/**
 * Created by Marton Bartal on 15.10.2020.
 */
public class Output {
    private int wordCount;

    public Output(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    @Override
    public String toString() {
        return "Number of words: " + wordCount;
    }
}
