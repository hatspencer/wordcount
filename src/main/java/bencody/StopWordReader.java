package bencody;

import bencody.util.FileLineReader;

import java.net.URL;
import java.util.List;

public class StopWordReader {

    private static final URL STOP_WORDS_URL = ClassLoader.getSystemResource("stopwords.txt");

    private StopWordReader() {
    }

    public static List<String> readStopWords() {
        return FileLineReader.readLines(STOP_WORDS_URL);
    }
}
