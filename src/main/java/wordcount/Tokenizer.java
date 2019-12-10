package wordcount;

import java.io.IOException;
import java.util.Optional;

/**
 * @author Nándor Előd Fekete
 */
public interface Tokenizer {

    Optional<String> nextToken() throws IOException;

}
