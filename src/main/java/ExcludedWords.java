import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ExcludedWords {
    public static final String EXCLUDED_FILE_NAME = "stopwords.txt";

    private List<String> excludedWords;
    private static ExcludedWords instance;

    private static File getStopWordsFile() {
        ClassLoader classLoader = new ExcludedWords().getClass().getClassLoader();
        return new File(classLoader.getResource(EXCLUDED_FILE_NAME).getFile());
    }

    private ExcludedWords() {
    }

    public static ExcludedWords getInstance() {
        if (instance != null) {
            return instance;
        }

        BufferedReader reader;
        List<String> excludedWords = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(getStopWordsFile()));
            String line = reader.readLine();
            while (line != null) {
                excludedWords.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ExcludedWords ew = new ExcludedWords();
        ew.excludedWords = excludedWords;
        instance = ew;
        return ew;
    }

    public List<String> getExcludedWords() {
        return excludedWords;
    }
}
