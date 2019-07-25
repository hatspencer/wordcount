package eu.wordcount;

import eu.wordcount.reader.CannotReadException;

import java.util.List;

public interface StopWordsReader {
    List<String> readWords() throws CannotReadException;
}
