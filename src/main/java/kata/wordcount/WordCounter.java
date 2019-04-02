package kata.wordcount;

import java.util.stream.Stream;

class WordCounter {

    long count(String text) {
        if (text == null) {
            return 0;
        }

        String[] words = text.split(" ");
        return Stream.of(words)
                .filter(word -> word.matches("[a-zA-z]+"))
                .count();
    }
}
