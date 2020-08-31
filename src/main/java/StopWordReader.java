import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StopWordReader {

    public List<String> readStopWords() {
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("stopwords.txt").toURI()))) {
            return stream.collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
