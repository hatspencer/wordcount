package wordcount;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;

/**
 * @author Nándor Előd Fekete
 */
public class WordCounter {

    public long wordCount(final Tokenizer tokenizer) throws IOException {
        long wordCount = 0;
        while (tokenizer.nextToken().isPresent()) {
            wordCount++;
        }
        return wordCount;
    }
}
