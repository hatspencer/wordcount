import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordDictionaryImpl implements StopWordDictionary {

    private static final String PATH_STOP_WORD = "src/resources/stopwords.txt";
    private static LoadStopWordInputImpl loadStopWordInput = new LoadStopWordInputImpl();

    @Override
    public Set<String> getStopWordDictionary() {
        try {
            BufferedReader bufferedReader = loadStopWordInput.getStopWordFileByPath(PATH_STOP_WORD);
            return Collections.unmodifiableSet(bufferedReader.lines().collect(Collectors.toSet()));
        } catch (IOException e) {
            System.out.println("Failed to load the Stop word dictionary. Stop word dictionary is therefore empty");
            e.printStackTrace();
        }
        return new HashSet<>();
    }
}
