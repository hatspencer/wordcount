import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
public class WordCount {

    private static final String STOPWORDS_RESOURCE = "stopwords.txt";

    private final Set<String> stopWords;
    private final List<String> inputWords;

    WordCount(Set<String> stopWords, List<String> inputWords) {
        this.stopWords = stopWords;
        this.inputWords = inputWords;
    }

    long getWordCount() {
        return inputWords.stream()
            .filter(word -> !stopWords.contains(word))
            .count();
    }

    public static void main(String[] args) {
        Set<String> stopWords = new StopWordsReader(STOPWORDS_RESOURCE).getStopWords();

        InputReader inputReader = getInputReader(args);
        if (inputReader == null) {
            System.out.println("Invalid number of arguments");

            return;
        }

        try {
            List<String> inputWords = new InputTextParser().parse(inputReader.readInput());
            System.out.println("Number of words: " + new WordCount(stopWords, inputWords).getWordCount());
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    static InputReader getInputReader(String[] args) {
        if (args.length == 0) {
            return new CommandLineInputReader();
        } else if (args.length == 1) {
            return new FileInputReader(args[0]);
        } else {
            return null;
        }
    }
}