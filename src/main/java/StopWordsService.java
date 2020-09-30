import java.io.InputStream;
import java.util.*;

public class StopWordsService {

    public Set<String> getStopWords() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("stopwords.txt");

        Scanner scanner = new Scanner(is);
        Set<String> stopwords = new HashSet<>();

        while(scanner.hasNext()) {
            String stopword = scanner.nextLine();
            stopwords.add(stopword);
        }
        scanner.close();
        return stopwords;
    }

}
