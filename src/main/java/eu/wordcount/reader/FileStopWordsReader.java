package eu.wordcount.reader;

import eu.wordcount.StopWordsReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileStopWordsReader implements StopWordsReader {

    private final String filePath;

    public FileStopWordsReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readWords() throws CannotReadException {

        List<String> stopWords = new ArrayList<>();

        URL resource = getClass().getClassLoader().getResource(filePath);

        if (resource == null) {
            throw new CannotReadException(String.format("Cannot find input file %s", filePath));
        }

        File file = new File(resource.getFile());
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
