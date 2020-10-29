import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StopWordReader {

    private String filePath;

    public StopWordReader(String filePath) {
        this.filePath = filePath;
    }

    public List<String> readStopWords() {
        try {
            return Files.lines(Paths.get(filePath)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
