package eu.wordcount.reader;

import eu.wordcount.WordReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWordReader implements WordReader {

    private final File file;

    public FileWordReader(File file) {
        this.file = file;
    }

    @Override
    public String readWords() throws CannotReadException {

        List<String> lines = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String word;
            while ((word = br.readLine()) != null)
                lines.add(word);

        } catch (FileNotFoundException e) {
            throw new CannotReadException(String.format("Cannot find input file %s", file.getPath()), e);
        } catch (IOException e) {
            throw new CannotReadException(String.format("Cannot read from input file %s", file.getPath()), e);
        }

        return String.join(" ", lines);
    }
}
