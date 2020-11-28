package com.dan.stopwords;

import com.dan.dictionary.Dictionary;
import com.dan.dictionary.DictionaryBuilder;
import com.dan.util.FileReader;

import java.io.IOException;
import java.util.List;

public class StopWords {

    private static final String STOPWORDS_FILE_PATH = "stopwords.txt";

    private Dictionary dictionary;

    StopWords(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public boolean contains(String word) {
        return dictionary.contains(word);
    }

    public static StopWords fromFile() {
        try {
            List<String> words = FileReader.readLinesFromClassPath(STOPWORDS_FILE_PATH);
            Dictionary dictionary = DictionaryBuilder.fromCollection(true, words);
            return new StopWords(dictionary);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while reading \"" + STOPWORDS_FILE_PATH + "\"");
        }
    }

    public static StopWords fromWords(String... words) {
        Dictionary dictionary = DictionaryBuilder.fromWords(true, words);
        return new StopWords(dictionary);
    }

}
