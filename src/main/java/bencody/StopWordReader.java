package bencody;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StopWordReader {

    private URL filePath;

    public StopWordReader() {
        this.filePath = ClassLoader.getSystemResource("stopwords.txt");
    }

    StopWordReader(URL filePathUrl) {
        this.filePath = filePathUrl;
    }

    public List<String> readStopWords() {
        try (Stream<String> stream = Files.lines(Paths.get(filePath.toURI()))) {
            return stream.collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
