package wordcount;

import java.io.IOException;
import java.io.Reader;
import java.util.Optional;

/**
 * Tokenizer implementation that reads tokens from a reader.
 * <p>
 * It considers words as valid tokens, words being defined as
 * blocks of characters delimited by whitespace (' '), containing only lowercase or uppercase latin characters.
 * <p>
 * The start and end of the stream are considered as whitespace.
 *
 * @author Nándor Előd Fekete
 */
public class ValidWordTokenizer implements Tokenizer {

    private final Reader reader;

    public ValidWordTokenizer(Reader reader) {
        this.reader = reader;
    }

    private boolean isWordChar(char input) {
        return 'a' <= input && input <= 'z'
            || 'A' <= input && input <= 'Z';
    }

    private boolean isWhiteSpace(char input) {
        return ' ' == input;
    }

    @Override
    public Optional<String> nextToken() {
        try {
            return tryNextToken();
        } catch (IOException e) {
            throw new TokenizerException(e);
        }
    }

    private Optional<String> tryNextToken() throws IOException {
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

    private static enum State {WHITESPACE, WORD, OTHER}
}
