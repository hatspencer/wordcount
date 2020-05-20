package cz.rleifer.test.wordcounter.core;

import java.io.IOException;

public interface StopwordHandler {
    String[] getStopWords() throws IOException;
}
