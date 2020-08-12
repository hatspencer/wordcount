package wordcount.wordcounter.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileInput implements Input {

    private String filename;

    public FileInput(String filename) {
        this.filename = filename;
    }

    @Override
    public String getInputData() throws IOException {
        File file = new File(filename);

        Scanner scnr = new Scanner(file);

        StringBuilder builder = new StringBuilder();

        while(scnr.hasNextLine()){
            String line = scnr.nextLine();
            builder.append(line);
            if (scnr.hasNextLine()) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }

}
