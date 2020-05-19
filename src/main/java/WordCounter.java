import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCounter {

    private static final WordCountResult EMPTY_RESULT = new WordCountResult(Collections.emptyList(), 0, 0, 0d);

    private final WordsDictionary stopWordsDictionary;
    private final WordsDictionary indexWordsDictionary;
    private final boolean indexWords;

    public WordCounter(WordsDictionary stopWordsDictionary, WordsDictionary indexWordsDictionary, boolean indexWords) {
        this.stopWordsDictionary = stopWordsDictionary;
        this.indexWordsDictionary = indexWordsDictionary;
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

        List<DictionaryWord> indexedWords = Collections.emptyList();
        if (indexWords) {
            indexedWords = allWords.stream()
                    .sorted(Comparator.comparing(Function.identity(), String.CASE_INSENSITIVE_ORDER))
                    .map(w -> new DictionaryWord(w, indexWordsDictionary.containsWord(w)))
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
        return !stopWordsDictionary.containsWord(word);
    }

    public static void main(String[] args) {
        ProgramArgumentsParser programArgumentsParser = new ProgramArgumentsParser(args);

        InputTextProvider inputTextProvider = getInputTextProvider(programArgumentsParser);
        WordCounter wordCounter = createWordCounter(programArgumentsParser);

        do {
            WordCountResult wordCountResult = wordCounter.getNumberOfWords(inputTextProvider.getInput());
            printConsoleResults(programArgumentsParser, wordCountResult);
        } while (!programArgumentsParser.isInputTextFileSet());
    }

    private static void printConsoleResults(ProgramArgumentsParser programArgumentsParser, WordCountResult wordCountResult) {
        System.out.println("Number of words: " + wordCountResult.getNumberOfWords() +
                ", unique: " + wordCountResult.getNumberOfUniqueWords() +
                ", average word length: " + wordCountResult.getAverageWordLength() + " characters");

        if (programArgumentsParser.isIndexedWords()) {
            if (programArgumentsParser.isIndexedDictionarySet()) {
                System.out.println("Index (unknown: " + wordCountResult.getNumberOfUnknownWords() + ")");
            } else {
                System.out.println("Index:");
            }
            wordCountResult.getIndexedWords().forEach(System.out::println);
        }
    }

    private static WordCounter createWordCounter(ProgramArgumentsParser programArgumentsParser) {
        WordsDictionary indexedWordsDictionary = programArgumentsParser.isIndexedDictionarySet() ?
                WordsDictionaryFactory.getInstance(programArgumentsParser.getDictionaryPath(), true) :
                (w) -> true;

        return new WordCounter(WordsDictionaryFactory.getStopWordsDictionaryInstance(),
                indexedWordsDictionary, programArgumentsParser.isIndexedWords());
    }

    private static InputTextProvider getInputTextProvider(ProgramArgumentsParser programArgumentsParser) {
        InputTextProvider inputTextProvider;
        if (programArgumentsParser.isInputTextFileSet()) {
            inputTextProvider = new FileInputTextProvider(programArgumentsParser.getInputTextFilePath());
        } else {
            inputTextProvider = new ConsoleInputTextProvider();
        }
        return inputTextProvider;
    }
}
