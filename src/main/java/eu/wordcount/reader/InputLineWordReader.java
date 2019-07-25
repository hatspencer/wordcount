package eu.wordcount.reader;

import eu.wordcount.WordReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputLineWordReader implements WordReader {

    private final BufferedReader reader;

    public InputLineWordReader(InputStream stream) {
        this.reader = new BufferedReader(new InputStreamReader(stream));
    }

    @Override
    public String readWords() {
        String input = null;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
