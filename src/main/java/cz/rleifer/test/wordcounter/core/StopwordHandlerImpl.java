package cz.rleifer.test.wordcounter.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class StopwordHandlerImpl implements StopwordHandler {
    private BufferedReader reader;

    public StopwordHandlerImpl(Reader reader) {
        this.reader = new BufferedReader(reader);
    }

    @Override
    public String[] getStopWords() throws IOException {
        List<String> stopWords = new ArrayList<>();
        String stopWord = reader.readLine();
        return null;
    }
}
