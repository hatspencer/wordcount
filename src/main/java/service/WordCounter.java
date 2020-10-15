package service;

import model.Output;

import java.util.List;

/**
 * Created by Marton Bartal on 15.10.2020.
 */
public interface WordCounter {

    /**
     * Counts the words, unique words and average word lengths
     * in a text (words are characters enclosed by whitespaces)
     * Stopwords are excluded in the counting.
     *
     * @param input the input text to count words for
     * @return the number of words.
     */
    Output processInput(String input);

    /**
     * Retrieve stopwords provided to this word counter.
     *
     * @return the stopwords.
     */
    List<String> getStopWords();
}
