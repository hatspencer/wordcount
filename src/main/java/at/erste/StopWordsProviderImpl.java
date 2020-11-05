package at.erste;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StopWordsProviderImpl implements StopWordsProvider {

    private static List<String> lowerCasedStopWords;

    private static String filename = "/stopwords.txt";

    @Override
    public List<String> getLowerCardStopWords() {
        if (lowerCasedStopWords == null) {
            List<String> strings = readAllLinesFromFile();
            List<String> lowerCasedFileEntries = strings
                    .stream()
                    .filter(t -> t != null)
                    .map(t -> t.toLowerCase())
                    .collect(Collectors.toList());
            lowerCasedStopWords = Collections.unmodifiableList(lowerCasedFileEntries);
        }

        return lowerCasedStopWords;
    }

    public List<String> readAllLinesFromFile() {
        InputStream inputStream = null;
        InputStreamReader inputStreamReader  = null;
        BufferedReader bufferedReader  = null;
        try {
            inputStream = getClass().getResourceAsStream(filename);
            inputStreamReader = new InputStreamReader(inputStream,  StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(inputStreamReader);
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error opening file " + filename + e);
            throw new IllegalStateException("Unable to read file " + filename);
        } finally {
            closeSilently(inputStream);
            closeSilently(inputStreamReader);
            closeSilently(bufferedReader);
        }
    }

    private void closeSilently(Closeable closable) {
        if (closable != null) {
            try {
                closable.close();
            } catch (IOException e) {

            }
        }
    }

    public static void setFilename(String filename) {
        StopWordsProviderImpl.filename = filename;
    }
}
