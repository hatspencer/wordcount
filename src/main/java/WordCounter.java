import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private Pattern pattern = Pattern.compile("([a-zA-Z]+)");
    private List<String> stopWords;

    public WordCounter(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public int countWords(String text) {
        Matcher matcher = pattern.matcher(text);
        return countMatches(matcher);
    }

    int countMatches(Matcher matcher) {
        int counter = 0;
        while (matcher.find()) {
            String word = matcher.group();
            if (!stopWords.contains(word)) {
                counter++;
            }
        }
        return counter;
    }
}
