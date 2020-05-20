package cz.rleifer.test.wordcounter.core;

import java.util.List;

public interface WordCounter {
    int countWords(String input, List<String> stopwords);
}
