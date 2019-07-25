package eu.wordcount;

import java.io.BufferedReader;
import java.io.IOException;

//todo(hovorkap) Not a good concept here, will do some decoupling
public class WordReader {

    public String readWords(BufferedReader reader) {
        String input = null;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
