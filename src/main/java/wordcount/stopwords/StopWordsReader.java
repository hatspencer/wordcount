package wordcount.stopwords;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StopWordsReader {
    
    private final String STOPWORDS_FILENAME = "stopwords.txt";

    public List<String> readWords() throws IOException, URISyntaxException {
        URL file = getClass().getClassLoader().getResource(STOPWORDS_FILENAME);
        List<Object> o = Files.lines(Paths.get(file.toURI()), StandardCharsets.UTF_8).collect(Collectors.toList());
        List<String> stopWords = new ArrayList<String>();
        for(Object s : o) {
            stopWords.add((String) s);
        }
        return stopWords;
    }

}
