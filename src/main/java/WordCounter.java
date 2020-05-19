import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCounter {

    private static final WordCountResult EMPTY_RESULT = new WordCountResult(0, 0);

    private final WordsDictionary dictionary;

    public WordCounter(WordsDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public WordCountResult getNumberOfWords(String text) {
        if (text == null || text.isEmpty()) {
            return EMPTY_RESULT;
        }

        List<String> allWords = Arrays.stream(text.split("[\\s\\-.,]+"))
                .filter(this::containsJustLetters)
                .filter(this::isNotStopWord)
                .collect(Collectors.toList());

        Set<String> allUniqueWords = new HashSet<>(allWords);

        return new WordCountResult(allWords.size(), allUniqueWords.size());
    }

    private boolean containsJustLetters(String stringToken) {
        return !stringToken.isEmpty() && stringToken.matches("[a-zA-Z]+");
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
                ", unique: " + wordCountResult.getNumberOfUniqueWords());
    }
}
