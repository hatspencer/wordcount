package io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

    public List<String> getStopwords(String fileName) throws IOException {
        Path path = FileSystems.getDefault().getPath(fileName).toAbsolutePath();
        return Files.readAllLines(path);
    }
}
