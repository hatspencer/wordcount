import java.io.IOException;
import java.util.Set;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
public class Application {

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
        WordCount.CountingResult countingResult = new WordCount(inputText, stopWords).count();

        // IO
        System.out.println("Number of words: " + countingResult.getWordsCount() + ", unique: " + countingResult.getUniqueWordsCount());
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
