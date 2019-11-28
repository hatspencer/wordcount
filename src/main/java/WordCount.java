import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
public class WordCount {

    private static final String STOPWORDS_RESOURCE = "stopwords.txt";

    public static void main(String[] args) {
        // IO
        Set<String> stopWords = new StopWordsReader(STOPWORDS_RESOURCE).getStopWords();

        // IO
        InputReader inputReader = getInputReader(args);
        if (inputReader == null) {
            System.out.println("Invalid number of arguments");

            return;
        }

        // IO
        String inputText;
        try {
            inputText = inputReader.readInput();
        } catch (IOException e) {
            System.out.println("An error occurred.");

            return;
        }

        // BL
        List<String> inputWords = new InputTextParser().parse(inputText);
        List<String> withoutStopWords = new StopWordsFilter(stopWords).filter(inputWords);

        long wordsCount = withoutStopWords.size();
        long uniqueWordsCount = new HashSet<>(withoutStopWords).size();

        // IO
        System.out.println("Number of words: " + wordsCount + ", unique: " + uniqueWordsCount);
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
