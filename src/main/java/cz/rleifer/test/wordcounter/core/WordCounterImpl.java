package cz.rleifer.test.wordcounter.core;

public class WordCounterImpl implements WordCounter {
    public int countWords(String input) {
        int wordCount = 0;
        String[] words = input.split(" ");
        for (String word : words) {
            if (word.matches("^[a-zA-Z]+$")) wordCount++;
        }
        return wordCount;
    }
}
