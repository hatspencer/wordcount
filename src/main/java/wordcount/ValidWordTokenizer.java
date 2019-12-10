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

        State state = State.WHITESPACE;
        int readResult;

        final StringBuilder sb = new StringBuilder();
        while ((readResult = reader.read()) != -1) {
            final char character = (char) readResult;
            boolean isWordChar = isWordChar(character);
            boolean isWhiteSpaceChar = isWhiteSpace(character);
            switch (state) {
                case OTHER:
                    if (isWhiteSpaceChar) {
                        state = State.WHITESPACE;
                    }
                    break;
                case WORD:
                    if (isWhiteSpaceChar) {
                        return Optional.of(sb.toString());
                    } else if (isWordChar) {
                        sb.append(character);
                    } else {
                        sb.setLength(0);
                        state = State.OTHER;
                    }
                    break;
                case WHITESPACE:
                    if (isWordChar) {
                        sb.append(character);
                        state = State.WORD;
                    } else if (!isWhiteSpaceChar) {
                        state = State.OTHER;
                    }
                    break;
            }
        }
        if (state == State.WORD) {
            return Optional.of(sb.toString());
        } else {
            //we only return empty when the stream ended
            return Optional.empty();
        }
    }
}
