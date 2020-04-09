package wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StopWords {

    private List<String> stopWords = new ArrayList<>();

    public StopWords() {
    }

    public List<String> readFromFile(String fileName) {
        stopWords.clear();

        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                stopWords.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.printf(" %s: file was not found", fileName);
            e.printStackTrace();
        }
        return stopWords;
    }
}
