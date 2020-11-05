package at.erste;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class FileReaderImpl implements FileReader {

    public String readContentOfFile(String path) {
        StringBuilder builder = new StringBuilder();
        processLine(path, t -> builder.append(t).append("\n"));
        return builder.toString();
    }

    public Set<String> getDictionary(String pathToFile) {
        Set<String> dictionary = new HashSet<>();
        processLine(pathToFile, t -> dictionary.add(t));
        return dictionary;
    }

    private void processLine(String path, Consumer<String> consumer ) {
        FileInputStream fileInputStream ;
        try {
            File fileToCheck = getFile(path);
            if (!fileToCheck.exists()) {
                System.out.println("The file does not exists.");
                throw new FileNotFoundException("File does not exist");
            }

            if (!fileToCheck.canRead()){
                System.out.println("The file is not readable for the program");
                throw new IllegalStateException("File is not accessible by the program");
            }

            fileInputStream = new FileInputStream(path);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    consumer.accept(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e.getMessage());
        }
    }

    protected File getFile(String path) {
        return new File(path);
    }

}
