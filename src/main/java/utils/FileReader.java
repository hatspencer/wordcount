package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class FileReader {
    public List<String> readFileLines(final String fileName) {
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));

            final List<String> fileLines = new ArrayList<>();

            String strLine;

            while ((strLine = br.readLine()) != null) {
                fileLines.add(strLine);
            }

            fileInputStream.close();

            return fileLines;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public String readWholeFile(final String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
    }
}
