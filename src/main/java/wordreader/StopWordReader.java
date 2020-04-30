package wordreader;

import java.util.Collection;

public class StopWordReader implements WordReader {

    public static final String STOP_WORDS_FILENAME = "src/main/resources/stopwords.txt";

    private static final FileWordReader FILE_WORD_READER = new FileWordReader(STOP_WORDS_FILENAME);

    @Override
    public Collection<String> readWords() {
        return FILE_WORD_READER.readWords();
    }
}
