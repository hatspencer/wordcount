package hiring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicWordCounter implements WordCounter {

    private static final Pattern CORRECT_WORD_PATTERN = Pattern.compile("^[a-zA-Z]+$");

    @Override
    public int countWords(String text) {
        String[] words = text.split("\\s");
        int count = 0;
        for (String word : words) {
            if (isCorrectWord(word)) {
                count++;
            }
        }
        return count;
    }

    private boolean isCorrectWord(String word) {
        Matcher matcher = CORRECT_WORD_PATTERN.matcher(word);
        return matcher.matches();
    }
}
