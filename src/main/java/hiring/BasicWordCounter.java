package hiring;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicWordCounter implements WordCounter {

    private static final Pattern CORRECT_WORD_PATTERN = Pattern.compile("^[a-zA-Z\\-]+$");

    private final StopWordsRepository stopWordsRepository;

    public BasicWordCounter(StopWordsRepository stopWordsRepository) {
        this.stopWordsRepository = stopWordsRepository;
    }

    @Override
    public WordCount countWords(String text) {
        String[] words = text.split("[\\s.,:;_?!\"(){}\\[\\]]");

        int totalWords = 0;
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            if (isCorrectWord(word) && !stopWordsRepository.containsWord(word)) {
                totalWords++;
                uniqueWords.add(word);
            }
        }
        return new WordCount(totalWords, uniqueWords.size());
    }

    private boolean isCorrectWord(String word) {
        Matcher matcher = CORRECT_WORD_PATTERN.matcher(word);
        return matcher.matches();
    }
}
