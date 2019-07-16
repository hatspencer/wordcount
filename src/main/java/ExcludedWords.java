import input.InputUtils;

import java.util.List;

public class ExcludedWords {
    private static final String EXCLUDED_FILE_NAME = "stopwords.txt";

    private List<String> excludedWords;
    private static ExcludedWords instance;


    private ExcludedWords() {
    }

    public static ExcludedWords getInstance() {
        if (instance != null) {
            return instance;
        }
        ExcludedWords ew = new ExcludedWords();
        ew.excludedWords = InputUtils.readFromResource(EXCLUDED_FILE_NAME);
        instance = ew;
        return ew;
    }

    public List<String> getExcludedWords() {
        return excludedWords;
    }
}
