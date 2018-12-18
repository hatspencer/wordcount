package at.egit.wordcount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WordCount {

    private List<String> stopWords = new ArrayList<>();

    void setStopWords(List<String> stopWords) {
        if (stopWords != null) {
            this.stopWords = stopWords;
        }
    }

    long countWords(String textToCount) {
        if (textToCount == null) {
            return 0;
        }

        return Arrays.stream(textToCount.split(" "))
                .filter(it -> !it.isEmpty())
                .filter(it -> !stopWords.contains(it))
                .count();
    }
}
