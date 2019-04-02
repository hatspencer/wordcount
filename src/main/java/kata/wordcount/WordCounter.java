package kata.wordcount;

import java.util.List;
import java.util.stream.Stream;

class WordCounter {

    private List<String> stopwords;

    WordCounter(List<String> stopwords) {
        this.stopwords = stopwords;
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
