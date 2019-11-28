import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
public class WordCount {

    private static final String STOPWORDS_RESOURCE = "stopwords.txt";

    public static void main(String[] args) {
        Set<String> stopWords = new StopWordsReader(STOPWORDS_RESOURCE).getStopWords();

        InputReader inputReader = getInputReader(args);
        if (inputReader == null) {
            System.out.println("Invalid number of arguments");

            return;
        }

        List<String> inputWords;
        try {
            inputWords = new InputTextParser().parse(inputReader.readInput());
        } catch (IOException e) {
            System.out.println("An error occurred.");

            return;
        }

        List<String> withoutStopWords = new StopWordsFilter(stopWords).filter(inputWords);

        System.out.println("Number of words: " + withoutStopWords.size() + ", unique: " + new HashSet<>(withoutStopWords).size());
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
