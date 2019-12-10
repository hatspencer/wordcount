package wordcount;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Counts the words returned by the {@link Tokenizer}.
 * 
 * @author Nándor Előd Fekete
 */
public class WordCounter {

    private final Predicate<String> filter;

    public WordCounter() {
        this(new StopWordsFilter(Collections.emptyList()));
    }

    public WordCounter(Predicate<String> filter) {
        this.filter = filter;
    }

    public long wordCount(final Tokenizer tokenizer) {
        long wordCount = 0;
        Optional<String> currentToken;
        while ((currentToken = tokenizer.nextToken()).isPresent()) {
            if (currentToken.filter(filter).isPresent()) {
                wordCount++;
            }
        }
        return wordCount;
    }
    
}
