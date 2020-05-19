import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCounter {

    private static final WordCountResult EMPTY_RESULT = new WordCountResult(Collections.emptyList(), 0, 0, 0d);

    private final WordsDictionary dictionary;
    private final boolean indexWords;

    public WordCounter(WordsDictionary dictionary, boolean indexWords) {
        this.dictionary = dictionary;
        this.indexWords = indexWords;
    }

    /**
     * We assume averageWordLength is calculated from all words matching conditions.
     * We assume indexed words are sorted in Alphabetical order without case sensitive
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

        List<String> indexedWords = Collections.emptyList();
        if (indexWords) {
            indexedWords = allWords.stream()
                    .sorted(Comparator.comparing(Function.identity(), String.CASE_INSENSITIVE_ORDER))
                    .collect(Collectors.toList());
        }

        return new WordCountResult(indexedWords, allWords.size(), allUniqueWords.size(), getAverageWordLength(allWords));
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

        boolean indexWords = isIndexSpecified(args);

        if (args.length > 0 && (!indexWords || args.length > 1) ) {
            inputTextProvider = new FileInputTextProvider(getFilePathFromArgs(args, indexWords));
        } else {
            inputTextProvider = new ConsoleInputTextProvider();
        }

        WordCounter wordCounter = new WordCounter(WordsDictionaryFactory.getInstance(), indexWords);
        WordCountResult wordCountResult = wordCounter.getNumberOfWords(inputTextProvider.getInput());

        System.out.println("Number of words: " + wordCountResult.getNumberOfWords() +
                ", unique: " + wordCountResult.getNumberOfUniqueWords() +
                ", average word length: " + wordCountResult.getAverageWordLength() + " characters");

        if (indexWords) {
            System.out.println("Index:");

            wordCountResult.getIndexedWords().forEach(System.out::println);
        }
    }

    private static String getFilePathFromArgs(String[] args, boolean indexWords) {
        if (indexWords) {
            return Objects.equals(args[0], "-index") ? args[1] : args[0];
        } else {
            return args[0];
        }
    }

    private static boolean isIndexSpecified(String[] args) {
        return Arrays.asList(args).contains("-index");
    }
}
