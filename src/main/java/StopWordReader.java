import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class StopWordReader {

    private static final String FILE_PATH = "stopwords.txt";

    public List<String> readStopWords() {
        try {
            Path path = Paths.get(this.getClass().getClassLoader().getResource(FILE_PATH).toURI());
            return Files.lines(path).collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Invalid file");
        }
    }
}
