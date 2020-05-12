package at.george.interview.infrastructure;

import at.george.interview.domain.IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderIO implements IO {

    private File inputFile;

    public FileReaderIO(File inputFile) {
        this.inputFile = inputFile;
    }

    public String readTextInputLine() {
        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            return readIntoSingleLine(bufferedReader);
        } catch (IOException e) {
            // would have used logger here
            return "";
        }
    }

    private String readIntoSingleLine(BufferedReader bufferedReader) throws IOException {
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            result.append(" ").append(line);
        }
        return result.toString();
    }

    public void printlnResultOutput(String output) {
        System.out.println(output);
    }

    @Override
    public void printInputQuery(String query) {
        System.out.print(query);
    }
}
