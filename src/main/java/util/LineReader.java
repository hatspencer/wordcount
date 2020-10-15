package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marton Bartal on 15.10.2020.
 * Class for reading list of words (separated by new line) from a file
 */
public class LineReader {

    private final String fileName;

    /**
     * Constructor for LineReader
     *
     * @param fileName the filename to read the lines from
     */
    public LineReader(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * Reads lines from a file.
     *
     * @return the list of stop words.
     */
    public List<String> readLinesFromFile() {
        List<String> stopWords = new ArrayList<>();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(this.fileName);
        if (is == null) {
            System.out.println("File not found");
            return stopWords;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
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
