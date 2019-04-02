package kata.wordcount;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInputReader implements InputReader {
    private Path path;

    FileInputReader(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new IllegalStateException(String.format("File %s not found", fileName));
        }
        path = Paths.get(file.toURI());
    }

    @Override
    public String read() {
        String result;
        try {
            result = new String(Files.readAllBytes(path), Charset.defaultCharset());
        } catch (IOException e) {
            throw new IllegalStateException(String.format("Failed to read file from %s", path), e);
        }

        return result;
    }
}
