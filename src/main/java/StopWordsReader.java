import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
class StopWordsReader {

    private final String filePath;

    public StopWordsReader(String filePath) {
        this.filePath = filePath;
    }

    Set<String> getStopWords() {
        // TODO catch NPE
        Scanner fileScanner = new Scanner(StopWordsReader.class.getResourceAsStream(filePath), "UTF-8").useDelimiter("\n");
        Set<String> stopwords = new HashSet<>();

        while (fileScanner.hasNext()) {
            stopwords.add(fileScanner.next());
        }

        return stopwords;
    }
}
