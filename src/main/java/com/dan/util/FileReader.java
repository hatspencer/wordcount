package com.dan.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

    private FileReader() {
        // prevent init
    }

    public static String readFile(String filePath) throws IOException {
        if (isBlank(filePath)) {
            throw new IllegalArgumentException("The filePath cannot be blank");
        }

        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public static List<String> readLinesFromClassPath(String fileName) throws IOException {
        if (isBlank(fileName)) {
            throw new IllegalArgumentException("The fileName cannot be blank");
        }

        InputStream inputStream = FileReader.class.getClassLoader().getResourceAsStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            return bufferedReader.lines().collect(Collectors.toList());
        }
    }

    private static boolean isBlank(String fileName) {
        return fileName == null || fileName.trim().isEmpty();
    }

}
