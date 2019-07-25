package eu.wordcount;

import java.util.List;

public interface StopListReader {
    List<String> readWords() throws CannotReadException;
}
