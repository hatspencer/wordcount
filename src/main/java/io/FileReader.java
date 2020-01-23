package io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

    public List<String> getStopwords() throws IOException {
        Path path = FileSystems.getDefault().getPath("stopwords.txt").toAbsolutePath();
        return Files.readAllLines(path);
    }
}
