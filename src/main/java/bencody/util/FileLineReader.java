package bencody.util;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileLineReader {

    private FileLineReader() {
    }

    public static List<String> readLines(URL filePathUrl) {
        try (Stream<String> stream = Files.lines(Paths.get(filePathUrl.toURI()))) {
            return stream.collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
