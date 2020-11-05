package at.erste;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class StopWordsProviderImpl implements StopWordsProvider {

    private static List<String> loweredStopWords;

    @Override
    public List<String> getLowerCardStopWords() {
        if (loweredStopWords == null) {

            List<String> strings = readAllLinesFromFile();
            loweredStopWords = strings
                    .stream()
                    .filter(t -> t != null)
                    .map(t -> t.toLowerCase())
                    .collect(Collectors.toList());
        }

        return loweredStopWords;
    }

    public List<String> readAllLinesFromFile() {
        String filename = "/stopwords.txt";
        InputStream inputStream = null;
        InputStreamReader inputStreamReader  = null;
        BufferedReader bufferedReader  = null;
        try {
            inputStream = getClass().getResourceAsStream(filename);
            inputStreamReader = new InputStreamReader(inputStream,  StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(inputStreamReader);
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error openin file " + filename + e);
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

}
