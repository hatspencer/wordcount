package wordcount;

import java.util.Optional;

/**
 * Tokenizer that returns individual tokens.
 *
 * @author Nándor Előd Fekete
 */
public interface Tokenizer {

    /**
     * Return the next token from the token stream, wrapped in an {@link Optional}.
     * <p>
     * Only valid tokens are returned, invalid tokens must be skipped. When are no more valid tokens, an empty Optional
     * is returned.
     *
     * @return an String token wrapped in an Optional
     * @throws TokenizerException if an error occurred while parsing
     */
    Optional<String> nextToken();

}
