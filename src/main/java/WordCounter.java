import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private Pattern pattern = Pattern.compile("([a-zA-Z]+)");
    private List<String> stopWords;

    public WordCounter(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public WordCountStatistics countWords(String text) {
        Matcher matcher = pattern.matcher(text);
        return countMatches(matcher);
    }

    private WordCountStatistics countMatches(Matcher matcher) {
        List<String> allWords = new ArrayList<>();
        Set<String> uniqueWords = new HashSet<>();
        while (matcher.find()) {
            String word = matcher.group();
            if (!stopWords.contains(word)) {
                allWords.add(word);
                uniqueWords.add(word.toLowerCase()); // Normalize case so that we don't count "a" and "A" twice.
            }
        }
        return new WordCountStatistics(allWords.size(), uniqueWords.size());
    }

    public static class WordCountStatistics {
        public final int totalCount;
        public final int uniqueCount;

        public WordCountStatistics(int totalCount, int uniqueCount) {
            this.totalCount = totalCount;
            this.uniqueCount = uniqueCount;
        }
    }
}
