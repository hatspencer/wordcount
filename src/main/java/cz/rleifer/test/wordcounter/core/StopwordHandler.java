package cz.rleifer.test.wordcounter.core;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public interface StopwordHandler {
    List<String> getStopWords(Reader reader) throws IOException;
}
