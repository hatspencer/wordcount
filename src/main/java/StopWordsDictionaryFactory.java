import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class StopWordsDictionaryFactory {

    private static WordsDictionary DEFAULT_INSTANCE = null;

    //not thread-safe
    public static WordsDictionary getInstance() {
        if (DEFAULT_INSTANCE == null) {
            initialize();
        }

        return DEFAULT_INSTANCE;
    }

    private static void initialize() {
        Set<String> stopWordsSet = new HashSet<>();

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(
                             StopWordsDictionary.class.getClassLoader().getResourceAsStream("stopwords.txt"))))
        {
            String word;
            while ((word = reader.readLine()) != null) {
                stopWordsSet.add(word);
            }

        } catch (IOException e) {
            System.out.println("Error during initialization of stop words dictionary: " + e.getMessage());
        } finally {
            DEFAULT_INSTANCE = new StopWordsDictionary(stopWordsSet);
        }

    }
}
