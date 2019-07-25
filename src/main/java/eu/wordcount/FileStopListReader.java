package eu.wordcount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileStopListReader implements StopListReader {

    private final String filePath;

    public FileStopListReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readWords() throws CannotReadException {
        List<String> stopWords = new ArrayList<>();

        File file = new File(filePath);
        try {

            BufferedReader br = null;
            br = new BufferedReader(new FileReader(file));

            String word;
            while ((word = br.readLine()) != null)
                stopWords.add(word);

        } catch (FileNotFoundException e) {
            throw new CannotReadException(String.format("Cannot find input file %s", filePath), e);
        } catch (IOException e) {
            throw new CannotReadException(String.format("Cannot read from input file %s", filePath), e);
        }

        return stopWords;
    }
}
