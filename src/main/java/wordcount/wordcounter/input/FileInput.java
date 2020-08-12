package wordcount.wordcounter.input;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
