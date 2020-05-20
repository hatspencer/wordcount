package cz.rleifer.test.wordcounter.core.impl;

import cz.rleifer.test.wordcounter.core.WordCounter;

import java.util.List;

public class WordCounterImpl implements WordCounter {
    public int countWords(String input, List<String> stopwords) {
        int wordCount = 0;
        String[] words = input.split(" ");

        for (String word : words) {
            if (word.matches(Constants.WORD_REG_EXPRESION) && !stopwords.contains(word.toLowerCase())) {
                wordCount++;
            }
        }
        return wordCount;
    }
}
