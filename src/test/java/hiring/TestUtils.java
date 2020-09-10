package hiring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestUtils {

    public static Path createTempFile(String prefix, String suffix, String content) {
        try {
            Path path = Files.createTempFile(prefix, suffix);
            Files.write(path, content.getBytes());
            return path;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
