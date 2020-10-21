package reader.validator;

public class WordValidator implements IWordValidator {
    private final static String VALID_WORD_REGEX = "[a-zA-Z]+";

    @Override
    public boolean isValidWord(final String string) {
        return string.matches(VALID_WORD_REGEX);
    }
}
