package com.dan.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    private FileReader() {
        // prevent init
    }

    public static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public static List<String> readLines(String filePath) throws IOException {
        File file = new File(filePath);
        return Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
    }

}
