package reader.validator;

import utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordValidator implements IWordValidator {
    private final static String VALID_WORD_REGEX = "[a-zA-Z]+";
    private final static String STOP_WORDS_FILE = "stopwords.txt";

    private List<String> stopWords;

    public WordValidator(FileReader fileReader) {
        try {
            stopWords = fileReader.readFileLines(STOP_WORDS_FILE);
        } catch (IOException ioException) {
            System.out.println("No stopwords file");
            stopWords = new ArrayList<>();
        }
    }

    @Override
    public boolean isValidWord(final String string) {
        return string.matches(VALID_WORD_REGEX) && !stopWords.contains(string);
    }
}
