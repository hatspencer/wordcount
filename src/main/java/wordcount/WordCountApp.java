package wordcount;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * Counts the words in the text read from standard input.
 * 
 * @author Nándor Előd Fekete
 */
public class WordCountApp {

    private final Reader input;
    private final PrintWriter output;
    private final WordCounter wordCounter;

    WordCountApp(final Reader input, PrintWriter output, String... args) throws IOException {
        this.output = output;
        this.wordCounter = new WordCounter(loadStopWordsFromFile());

        if (args != null && args.length >= 1) {
            this.input = new FileReader(args[0]);
        } else {
            this.input = input;
        }

        run();
    }

    private StopWordsPredicate loadStopWordsFromFile() throws IOException {
        final StopWordsPredicate stopWordsPredicate;
        try (final InputStream stopWordsInputStream = WordCountApp.class.getClassLoader()
            .getResourceAsStream("stopwords.txt")) {
            stopWordsPredicate = StopWordsPredicate.fromInputStream(stopWordsInputStream);
        }
        return stopWordsPredicate;
    }

    void run() throws IOException {

        output.print("Enter text: ");
        output.flush();

        final long wordCount = wordCounter.wordCount(new ValidWordTokenizer(input));
        output.printf("Number of words: %d\n", wordCount);

    }

    public static void main(String[] args) throws IOException {
        try (Reader input = new InputStreamReader(System.in); PrintWriter output = new PrintWriter(System.out, true)) {
            new WordCountApp(input, output);
        }
    }

}
