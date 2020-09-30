import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SanitizingServiceImpl implements SanitizingService {

    private static final String SPLITTING_REGEX = "\\s|\\.";
    private static final String WORD_REGEX = "[a-zA-Z|-]+";

    private Set<String> stopwords;

    public SanitizingServiceImpl(Set<String> stopwords) {
        this.stopwords = stopwords;
    }

    @Override
    public List<String> getSanitizedWords(String text) {
        if (text == null) {
            return new ArrayList<>();
        }
        String[] textParts = text.split(SPLITTING_REGEX);

        List<String> sanitizedWords = new ArrayList<>();
        for (String word: textParts) {
            if (!stopwords.contains(word) && word.matches(WORD_REGEX)) {
                sanitizedWords.add(word);
            }
        }
        return sanitizedWords;
    }
}
