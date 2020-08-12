package wordcount.stopwords;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StopWordsReader {

    public static List<String> readWords(Path file) throws IOException {
        List<Object> o = Files.lines(file, StandardCharsets.UTF_8).collect(Collectors.toList());
        List<String> stopWords = new ArrayList<String>();
        for(Object s : o) {
            stopWords.add((String) s);
        }
        return stopWords;
    }

}
