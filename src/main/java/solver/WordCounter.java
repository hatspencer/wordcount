package solver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for word counting.
 * Assertion: whitespaces are "\\s+";
 */
public class WordCounter {

    private static final String STOPWORDS_FILENAME = "stopwords.txt";
    private static final String WHITESPACE_REGEX = "\\s+";
    private static final String ALLOWED_WORD_CHARSET_REGEX = "[a-zA-Z]+";

    /**
     * Reads the stop words from the file.
     * @return the list of stop words.
     */
    public List<String> readStopWords() {
        List<String> stopWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(STOPWORDS_FILENAME));) {
            String line = "";
            while (line != null) {
                line = reader.readLine();
                if (!line.isEmpty()) {
                    stopWords.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("There was an error reading the stopwords.");
        }
        return stopWords;
    }

    /**
     * Counts the words in a text (words are characters enclosed by whitespaces)
     *
     * @param text the input text to count words for
     * @return the number of words.
     */
    public int countWords(String text) {
        String[] arr = text.split(WHITESPACE_REGEX);
        int wordCount = arr.length;
        for (String word : arr) {
            if (!word.matches(ALLOWED_WORD_CHARSET_REGEX)) {
                wordCount--;
            }
        }
        return wordCount;
    }
}
