package wordcount;

import java.io.IOException;

/**
 * Counts the words returned by the {@link Tokenizer}
 * 
 * @author Nándor Előd Fekete
 */
public class WordCounter {

    public long wordCount(final Tokenizer tokenizer) {
        long wordCount = 0;
        while (tokenizer.nextToken().isPresent()) {
            wordCount++;
        }
        return wordCount;
    }
    
}
