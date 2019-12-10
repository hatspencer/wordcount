package wordcount;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Supplier of {@link StopWordsFilter} that reads lines from an {@link InputStream}, each line being a filtered word
 * that would test as false in the predicate.
 *
 * @author Nándor Előd Fekete
 */
public class InputStreamStopWordFilterSupplier implements Supplier<StopWordsFilter> {

    private final StopWordsFilter stopWordFilter;

    public InputStreamStopWordFilterSupplier(InputStream inputStream) throws IOException {
        final LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream));
        final Set<String> stopWords = new HashSet<>();
        String line;
        while ((line = lineNumberReader.readLine()) != null) {
            stopWords.add(line);
        }
        this.stopWordFilter = new StopWordsFilter(stopWords);
    }

    @Override
    public StopWordsFilter get() {
        return stopWordFilter;
    }
}
