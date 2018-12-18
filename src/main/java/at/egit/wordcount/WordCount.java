package at.egit.wordcount;

import java.util.Arrays;

class WordCount {

    long countWords(String textToCount) {
        if (textToCount == null) {
            return 0;
        }

        return Arrays.stream(textToCount.split(" "))
                .filter(it -> !it.isEmpty())
                .count();
    }
}
