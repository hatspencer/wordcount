import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SanitizingService {

    private Set<String> stopwords;

    public SanitizingService(Set<String> stopwords) {
        this.stopwords = stopwords;
    }

    public List<String> getSanitizedWords(String text) {
        if (text == null) {
            return new ArrayList<>();
        }
        String[] textParts = text.split("\\s|\\.|-");

        List<String> sanitizedWords = new ArrayList<>();
        for (String word: textParts) {
            if (!stopwords.contains(word) && word.matches("[a-zA-Z]+")) {
                sanitizedWords.add(word);
            }
        }
        return sanitizedWords;
    }
}
