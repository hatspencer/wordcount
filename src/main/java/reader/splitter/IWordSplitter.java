package reader.splitter;

import java.util.List;

public interface IWordSplitter {
    List<String> splitTextIntoWords(final String text);
}
