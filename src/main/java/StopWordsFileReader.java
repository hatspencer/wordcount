import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
class StopWordsFileReader {

    private final String filePath;

    StopWordsFileReader(String filePath) {
        this.filePath = filePath;
    }

    Set<String> getStopWords() {
        try {
            Scanner fileScanner = new Scanner(
                StopWordsFileReader.class.getResourceAsStream(filePath),
                "UTF-8"
            ).useDelimiter("\n");
            Set<String> stopwords = new HashSet<>();

            while (fileScanner.hasNext()) {
                stopwords.add(fileScanner.next());
            }

            return stopwords;
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new RuntimeException("Error reading file");
        }
    }
}
