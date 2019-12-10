package wordcount;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;

/**
 * @author Nándor Előd Fekete
 */
public class WordCounter {

    public long wordCount(Reader reader) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(reader);
        tokenizer.resetSyntax();
        tokenizer.wordChars('a', 'z');
        tokenizer.wordChars('A', 'Z');
        tokenizer.whitespaceChars(' ', ' ');

        long counter = 0;
        int tokenType;
        while ((tokenType = tokenizer.nextToken()) != StreamTokenizer.TT_EOF) {
            if (tokenType == StreamTokenizer.TT_WORD) {
                counter++;
            }
        }
        return counter;
    }
}
