import java.util.*;

public class CountService {

    private SanitizingService sanitizingService;

    public CountService(SanitizingService sanitizingService) {
        this.sanitizingService = sanitizingService;
    }

    public Statistics countWords(String text) {
        List<String> sanitizedWords = sanitizingService.getSanitizedWords(text);
        Statistics statistics = new Statistics();
        statistics.setUniqueWordCount(countUniqueWords(sanitizedWords));
        statistics.setAllWordCount(countAllWords(sanitizedWords));
        return statistics;
    }



    private int countUniqueWords(List<String> textParts) {
        Set<String> uniqueWords = new HashSet<>(textParts);
        return uniqueWords.size();
    }

    private int countAllWords(List<String> textParts) {
        return textParts.size();
    }
}
