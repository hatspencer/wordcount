package wordreader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class ReaderBase implements WordReader {

    List<String> getWordsFromSentence(String sentence) {

        if (sentence == null) {
            return Collections.emptyList();
        }

        String whiteListedSentence =  sentence
                .replace("-", " ") // alternative separator to space

                // punctuation characters should be ignored
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "")
                .replace(";", "")
        ;

        return Arrays.asList(whiteListedSentence.split(" "));
    }

}
