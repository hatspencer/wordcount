package hiring.input;

import hiring.TextProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileTextProvider implements TextProvider {

    private final Path filePath;

    public FileTextProvider(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public String provideText() {
        try {
            byte[] bytes = Files.readAllBytes(filePath);
            return new String(bytes);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
