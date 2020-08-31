import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private Pattern pattern = Pattern.compile("[a-zA-Z]+");

    public int countWords(String text) {
        Matcher matcher = pattern.matcher(text);
        return countMatches(matcher);
    }

    static int countMatches(Matcher matcher) {
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }
}
