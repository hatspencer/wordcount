import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
public class FileInputReader implements InputReader {

    private final String filePath;

    public FileInputReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String readInput() throws IOException {
        return Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)
            .collect(Collectors.joining("\n"));
    }
}
