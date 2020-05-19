import java.util.*;
import java.util.stream.Collectors;

public class WordCounter {

    private static final WordCountResult EMPTY_RESULT = new WordCountResult(0, 0, 0d);

    private final WordsDictionary dictionary;

    public WordCounter(WordsDictionary dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * We assume averageWordLength is calculated from all words matching conditions.
     */
    public WordCountResult getNumberOfWords(String text) {
        if (text == null || text.isEmpty()) {
            return EMPTY_RESULT;
        }

        List<String> allWords = Arrays.stream(text.split("[\\s.,]+"))
                .filter(this::containsJustLetters)
                .filter(this::isNotStopWord)
                .collect(Collectors.toList());

        Set<String> allUniqueWords = new HashSet<>(allWords);

        return new WordCountResult(allWords.size(), allUniqueWords.size(), getAverageWordLength(allWords));
    }

    private double getAverageWordLength(Collection<String> wordsSet) {
        return wordsSet.isEmpty() ? 0 :  ((double) wordsSet
                .stream()
                .map(String::length)
                .reduce(0, Integer::sum)) / wordsSet.size();
    }

    private boolean containsJustLetters(String stringToken) {
        return !stringToken.isEmpty() && stringToken.matches("[a-zA-Z\\-]+");
    }

    private boolean isNotStopWord(String word) {
        return !dictionary.containsWord(word);
    }

    public static void main(String[] args) {
        InputTextProvider inputTextProvider;

        if (args.length > 0 && !args[0].isEmpty()) {
            inputTextProvider = new FileInputTextProvider(args[0]);
        } else {
            inputTextProvider = new ConsoleInputTextProvider();
        }

        WordCounter wordCounter = new WordCounter(WordsDictionaryFactory.getInstance());
        WordCountResult wordCountResult = wordCounter.getNumberOfWords(inputTextProvider.getInput());

        System.out.println("Number of words: " + wordCountResult.getNumberOfWords() +
                ", unique: " + wordCountResult.getNumberOfUniqueWords() +
                ", average word length: " + wordCountResult.getAverageWordLength() + " characters");
    }
}
