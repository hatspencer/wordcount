package WordsCount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputProvider {

    public static List<String> getInputFromResourceFile(String resource) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        return getInputFromFile(classloader.getResource(resource).getPath());
    }

    public static List<String> getInputFromFile(String path) {
        try (Stream<String> words = Files.lines(Paths.get(path))) {
            return words.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
