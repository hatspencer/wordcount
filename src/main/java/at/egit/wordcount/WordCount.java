package at.egit.wordcount;

import java.util.Arrays;
import java.util.List;

class WordCount {

    private List<String> stopWords;

    long countWords(String textToCount) {
        if (textToCount == null) {
            return 0;
        }

        return Arrays.stream(textToCount.split(" "))
                .filter(it -> !it.isEmpty())
                .count();
    }
}
