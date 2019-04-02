package kata.wordcount;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

class WordCounter {

    private List<String> stopwords;
    private static final String stopWordsFileName = "stopwords.txt";

    WordCounter() {
        try {
            URL stopwordsUrl = this.getClass().getResource(stopWordsFileName);
            stopwords = Files.readAllLines(
                    Paths.get(stopwordsUrl.toURI()), Charset.defaultCharset());
        } catch (IOException | URISyntaxException ex) {
            throw new IllegalStateException(String.format("Unable to read from stopwords file %s", stopWordsFileName), ex);
        }
    }

    private boolean isValidWord(String word) {
        return word.matches("[a-zA-z]+");
    }

    long count(String text) {
        if (text == null) {
            return 0;
        }

        String[] words = text.split(" ");
        return Stream.of(words)
                .filter(this::isValidWord)
                .filter(this::isNotStopword)
                .count();
    }

    private boolean isNotStopword(String word) {
        return !stopwords.contains(word);
    }

}
