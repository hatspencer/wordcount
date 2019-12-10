package wordcount;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Predicate implementation that passes only for strings that are not in a predefined set of strings.
 *
 * @author Nándor Előd Fekete
 */
public class StopWordsPredicate implements Predicate<String> {


    private final Set<String> filteredWords;

    /**
     * Create the <code>StopWordsFilter</code> from the provided collection of strings.
     * 
     * @param filteredWords
     */
    public StopWordsPredicate(Collection<String> filteredWords) {
        this.filteredWords = new HashSet<>(filteredWords);
    }

    @Override
    public boolean test(String s) {
        return !filteredWords.contains(s);
    }

    /**
     * Builds a <code>StopWordsFilter</code> from an {@link InputStream}. The stream should contain the words meant
     * to be filtered out, one word on each line. The whole line will be considered as a stop-word, even if it's not a
     * valid word.
     *
     * @param inputStream
     * @return the resulting {@link StopWordsPredicate}
     * @throws IOException if reading from the input stream fails.
     */
    public static StopWordsPredicate fromInputStream(final InputStream inputStream) throws IOException {
        final LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream));
        final Set<String> stopWords = new HashSet<>();
        String line;
        while ((line = lineNumberReader.readLine()) != null) {
            stopWords.add(line);
        }
        return new StopWordsPredicate(stopWords);
    }

}
