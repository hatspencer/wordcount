package cz.rleifer.test.wordcounter.core;

import java.io.IOException;
import java.util.Optional;

public interface InputStringHandler {
    Optional<String> readLine();
    boolean next() throws IOException;
}
