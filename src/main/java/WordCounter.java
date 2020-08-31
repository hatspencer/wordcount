import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {

    private Pattern pattern = Pattern.compile("([a-zA-Z-]+)");
    private List<String> stopWords;

    public WordCounter(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public WordCountStatistics countWords(String text) {
        return countWords(text, false);
    }

    public WordCountStatistics countWords(String text, boolean outputIndex) {
        Matcher matcher = pattern.matcher(text);
        return countMatches(matcher, outputIndex);
    }

    private WordCountStatistics countMatches(Matcher matcher, boolean outputIndex) {
        List<String> allWords = new ArrayList<>();
        while (matcher.find()) {
            String word = matcher.group();
            if (!stopWords.contains(word)) {
                allWords.add(word);
            }
        }

        List<String> index = Collections.emptyList();
        if (outputIndex) {
            index = allWords.stream()
                    .sorted(Collator.getInstance())
                    .collect(Collectors.toList());
        }

        List<String> uniqueWords = allWords.stream()
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());

        double averageWordLength = allWords.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0d);

        return new WordCountStatistics(allWords.size(), uniqueWords.size(), averageWordLength, index);
    }

    public static class WordCountStatistics {
        public final int totalCount;
        public final long uniqueCount;
        public final double averageWordLength;
        public final List<String> index;

        public WordCountStatistics(int totalCount, long uniqueCount, double averageWordLength, List<String> index) {
            this.totalCount = totalCount;
            this.uniqueCount = uniqueCount;
            this.averageWordLength = averageWordLength;
            this.index = index;
        }
    }
}
