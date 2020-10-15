package service;

import model.Output;

/**
 * Created by Marton Bartal on 15.10.2020.
 */
public interface WordCounterService {

    /**
     * Counts the words in a text (words are characters enclosed by whitespaces)
     * Stopwords are excluded in the counting
     *
     * @param input the input text to count words for
     * @return the number of words.
     */
    Output processInput(String input);
}
