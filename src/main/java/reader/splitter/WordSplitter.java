package reader.splitter;

import java.util.Arrays;
import java.util.List;

public class WordSplitter implements IWordSplitter {
    private static final String MULTIPLE_SPACES_REGEX = " +";

    public List<String> splitTextIntoWords(final String text) {
        return Arrays.asList(text.split(MULTIPLE_SPACES_REGEX));
    }
}
