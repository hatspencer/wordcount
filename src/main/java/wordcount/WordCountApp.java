package wordcount;

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

    static void run(Reader in, PrintWriter out) throws IOException {
        final InputStream stopWordsInputStream = WordCountApp.class.getClassLoader()
            .getResourceAsStream("stopwords.txt");

        out.print("Enter text: ");
        final WordCounter wordCounter = new WordCounter(StopWordsPredicate.fromInputStream(stopWordsInputStream));
        final long wordCount = wordCounter.wordCount(new ValidWordTokenizer(in));
        out.printf("Number of words: %d\n", wordCount);
    }

    public static void main(String[] args) throws IOException {
        run(new InputStreamReader(System.in), new PrintWriter(System.out));
    }

}
