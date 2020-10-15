package service;

import java.util.List;

/**
 * Created by Marton Bartal on 15.10.2020.
 */
public interface LineReader {

    /**
     * Reads lines from a file.
     *
     * @return the list of stop words.
     */
    List<String> readLinesFromFile();
}
