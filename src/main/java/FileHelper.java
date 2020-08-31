import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileHelper {
    public static List<String> readAllLines(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    }
}
