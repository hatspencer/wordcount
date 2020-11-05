package at.erste;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderImpl implements FileReader {

    public String readContentOfFile(String path) {
        StringBuilder resultStringBuilder = new StringBuilder();

        FileInputStream fileInputStream ;
        try {
            File fileToCheck = new File(path);
            if (!fileToCheck.exists()) {
                System.out.println("The file does not exists.");
                throw new FileNotFoundException("File does not exist");
            }

            fileInputStream = new FileInputStream(path);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    resultStringBuilder.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e.getMessage());
        }
        System.out.println("Readed line \n" + resultStringBuilder.toString());
        return resultStringBuilder.toString();
    }
}
