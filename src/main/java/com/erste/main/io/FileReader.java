package com.erste.main.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<String> readFileAsLines(String filePath) {
        List<String> lines = new ArrayList<>();

        InputStream resourceStream = FileReader.class.getResourceAsStream(filePath);
        InputStreamReader isr = new InputStreamReader(resourceStream);
        BufferedReader bufferedReader = new BufferedReader(isr);

        try {
            String line = bufferedReader.readLine();

            while (line != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
