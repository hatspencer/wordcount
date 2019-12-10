package wordcount;

import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nándor Előd Fekete
 */
public class ValidWordTokenizer implements Tokenizer {

    private static enum State { WHITESPACE, WORD, OTHER }

    private final Reader reader;

    public ValidWordTokenizer(Reader reader) {
        this.reader = reader;
    }

    private boolean isWordChar(char input) {
        return 'a' <= input && input <='z'
            || 'A' <= input && input <= 'Z';
    }

    private boolean isWhiteSpace(char input) {
        return ' ' == input;
    }

    @Override
    public Optional<String> nextToken() throws IOException {
        int readResult;

        State state = State.OTHER;
        while ((readResult = reader.read()) != -1) {
            final char character = (char) readResult;
            boolean isWordChar = isWordChar(character);
            boolean isWhiteSpaceChar = isWhiteSpace(character);
//            switch (state) {
//                case OTHER:
//            }
        }
        return Optional.empty();
    }
}
