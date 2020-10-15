package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marton Bartal on 15.10.2020.
 * Class for reading list of words (separated by new line) from a file
 */
public class WordsReaderFromFile {

    private final String fileName;

    /**
     * Constructor for WordsReaderFromFile
     * @param fileName the filename to read the words from
     */
    public WordsReaderFromFile(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * Reads the stop words from the file.
     * @return the list of stop words.
     */
    public List<String> readWordsFromFile() {
        List<String> stopWords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            while (line != null) {
                line = reader.readLine();
                if (line != null && !line.isEmpty()) {
                    stopWords.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("There was an error reading the words from the file.");
        }
        return stopWords;
    }
}
