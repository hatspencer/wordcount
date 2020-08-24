package at.george.wordcount;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

    public List<String> asList(String filePath) {
        try {
            Path path = getPath(filePath);
            return Files.readAllLines(path)
                    .stream()
                    .map(line -> line.split(" "))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public String asString(String filePath) {
        try {
            Path path = getPath(filePath);
            return String.join(" " ,Files.readAllLines(path));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return "";
        }
    }

    private Path getPath(String filePath) throws URISyntaxException {
        URI uri = ClassLoader.getSystemResource(filePath)
                .toURI();
        return Paths.get(uri);
    }


}
