package hiring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicWordCounter implements WordCounter {

    private static final Pattern CORRECT_WORD_PATTERN = Pattern.compile("^[a-zA-Z]+$");

    private final StopWordsRepository stopWordsRepository;

    public BasicWordCounter(StopWordsRepository stopWordsRepository) {
        this.stopWordsRepository = stopWordsRepository;
    }

    @Override
    public int countWords(String text) {
        String[] words = text.split("\\s");
        int count = 0;
        for (String word : words) {
            if (isCorrectWord(word) && !stopWordsRepository.containsWord(word)) {
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
