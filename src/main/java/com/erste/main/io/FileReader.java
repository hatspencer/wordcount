package com.erste.main.io;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileReader {

    public static List<String> readFileAsLines(String fileName) {
        try {
            Path path = Paths.get(FileReader.class.getClassLoader().getResource(fileName).toURI());
            return Files.readAllLines(path);
        } catch (URISyntaxException | IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
