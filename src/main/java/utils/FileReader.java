package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public List<String> readFile(final String fileName) throws IOException {
        FileInputStream fstream = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        final List<String> fileLines = new ArrayList<>();

        String strLine;

        while ((strLine = br.readLine()) != null) {
            fileLines.add(strLine);
        }

        fstream.close();

        return fileLines;
    }
}
