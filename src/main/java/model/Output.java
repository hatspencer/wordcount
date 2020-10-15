package model;

import java.util.HashSet;

/**
 * Created by Marton Bartal on 15.10.2020.
 */
public class Output {
    private int wordCount;
    private HashSet<String> words = new HashSet<>();

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void addWord(String word) {
        words.add(word);
    }

    public int getUniqueWordCount() {
        return words.size();
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
