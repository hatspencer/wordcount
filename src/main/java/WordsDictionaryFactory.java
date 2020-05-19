import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class WordsDictionaryFactory {

    private static final String STOP_WORDS_DICTIONARY_NAME = "stopwords.txt";

    public static WordsDictionary getStopWordsDictionaryInstance() {
        return getInstance(STOP_WORDS_DICTIONARY_NAME, false);
    }

    /**
     * For an arbitrary words dictionary path
     */
    public static WordsDictionary getInstance(String path, boolean fromFileSystem) {
        Set<String> stopWordsSet = new HashSet<>();

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(
                             getFileStream(path, fromFileSystem)))) {
            String word;
            while ((word = reader.readLine()) != null) {
                stopWordsSet.add(word);
            }

        } catch (IOException e) {
            System.out.println("Error during initialization of words dictionary: " + e.getMessage());
        }
        return new HashWordsDictionary(stopWordsSet);
    }

    private static InputStream getFileStream(String path, boolean fromFileSystem) throws FileNotFoundException {
        return fromFileSystem ?  new FileInputStream(new File(path))
                : HashWordsDictionary.class.getClassLoader().getResourceAsStream(path);
    }

}
