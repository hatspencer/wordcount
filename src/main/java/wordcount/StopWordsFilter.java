package wordcount;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Predicate implementation that passes only for strings that are not in a predefined set of strings.
 *
 * @author Nándor Előd Fekete
 */
public class StopWordsFilter implements Predicate<String> {

    private final Set<String> filteredWords;

    /**
     * Create the <code>StopWordsFilter</code> from the provided collection of strings.
     * 
     * @param filteredWords
     */
    public StopWordsFilter(Collection<String> filteredWords) {
        this.filteredWords = new HashSet<>(filteredWords);
    }

    @Override
    public boolean test(String s) {
        return !filteredWords.contains(s);
    }
    
}
