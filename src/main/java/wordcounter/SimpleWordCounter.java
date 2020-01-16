package wordcounter;

import processor.WordCounter;

import java.util.Arrays;
import java.util.Set;

public class SimpleWordCounter implements WordCounter {

    private String userInput;
    private String delimiters = "[\\s.,]";
    private Set<String> stopWords;

    public SimpleWordCounter(String userInput, Set<String> stopWords) {
        this.userInput = userInput;
        this.stopWords = stopWords;
    }

    @Override
    public int countWords() {

        if ("".equals(userInput.trim()))
            return 0;

        String[] splitInput = this.userInput.split(this.delimiters);
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
