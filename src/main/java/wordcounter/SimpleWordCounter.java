package wordcounter;

import processor.WordCounter;

import java.util.Arrays;
import java.util.Set;

public class SimpleWordCounter implements WordCounter {

    private String delimiters = "[\\s.,]";
    private Set<String> stopWords;

    public SimpleWordCounter(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public int countWords(String userInput) {

        if ("".equals(userInput.trim()))
            return 0;

        String[] splitInput = userInput.split(this.delimiters);
        return Long.valueOf(Arrays.stream(splitInput)
                .filter(s -> !s.isEmpty())
                .filter(s -> !stopWords.contains(s))
                .count())
                .intValue();
    }

    public void setDelimiters(String delimiters) {
        this.delimiters = delimiters;
    }


}
