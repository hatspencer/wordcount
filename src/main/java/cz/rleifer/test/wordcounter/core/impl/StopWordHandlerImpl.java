package cz.rleifer.test.wordcounter.core.impl;

import cz.rleifer.test.wordcounter.core.StopwordHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import static cz.rleifer.test.wordcounter.core.impl.Constants.WORD_REG_EXPRESION;

public class StopWordHandlerImpl implements StopwordHandler {

    @Override
    public List<String> getStopWords(Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        List<String> stopWords = new ArrayList<>();
        String stopWord = bufferedReader.readLine();
        while (stopWord != null) {
            String[] splittedWords =  stopWord.split("\\s");
            if (splittedWords.length != 0 && !splittedWords[0].isEmpty() && splittedWords[0].matches(WORD_REG_EXPRESION)) {
                stopWords.add(splittedWords[0].toLowerCase());
            }
            stopWord = bufferedReader.readLine();
        }
        return stopWords;
    }
}
