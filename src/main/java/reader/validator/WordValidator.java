package reader.validator;

import java.util.ArrayList;
import java.util.List;

public class WordValidator implements IWordValidator {
    private final static String VALID_WORD_REGEX = "^[A-Za-z]+((-[A-Za-z]+)+)?\\.?$";

    private List<String> stopWords;

    public WordValidator() {
        stopWords = new ArrayList<>();
    }

    public WordValidator(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public boolean isValidWord(final String string) {
        return string.matches(VALID_WORD_REGEX) && !stopWords.contains(string);
    }

    public void setStopWords(final List<String> stopWords) {
        this.stopWords = stopWords;
    }
}
