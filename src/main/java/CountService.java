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
        statistics.setAverageLength(countAverageLength(sanitizedWords));
        statistics.setAllUniqueWords(getAllUniqueWords(sanitizedWords));
        return statistics;
    }



    private int countUniqueWords(List<String> textParts) {
        Set<String> uniqueWords = new HashSet<>(textParts);
        return uniqueWords.size();
    }

    private int countAllWords(List<String> textParts) {
        return textParts.size();
    }

    private double countAverageLength(List<String> textParts) {
        if (textParts.isEmpty()) {
            return 0;
        }
        long sum = 0;
        for (String word : textParts) {
            sum += word.length();
        }
        return (double) sum / textParts.size();
    }

    public Set<String> getAllUniqueWords(List<String> textParts) {
        return new HashSet<>(textParts);
    }
}
