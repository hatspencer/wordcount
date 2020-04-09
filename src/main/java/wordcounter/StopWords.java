package wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StopWords {

    private List<String> stopWords = new ArrayList<>();

    public StopWords() { }

    public StopWords(File file) {
        if(file == null) {
            return;
        }

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                stopWords.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.printf(" %s: file was not found", file);
            e.printStackTrace();
        }
    }

    public boolean isStopword(String word) {
        return stopWords.contains(word);
    }

    public boolean isNoStopword(String word) {
        return !isStopword(word);
    }
}
