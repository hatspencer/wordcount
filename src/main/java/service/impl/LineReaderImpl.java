package service.impl;

import service.LineReader;

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
public class LineReaderImpl implements LineReader {

    private final String fileName;

    /**
     * Constructor for LineReader
     *
     * @param fileName the filename to read the lines from
     */
    public LineReaderImpl(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> readLinesFromFile() {
        List<String> resultLines = new ArrayList<>();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(this.fileName);
        if (is == null) {
            System.err.println("File not found.");
            return resultLines;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line = "";
            while (line != null) {
                line = reader.readLine();
                if (line != null && !line.isEmpty()) {
                    resultLines.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("There was an error reading the words from the file.");
        }
        return resultLines;
    }
}
