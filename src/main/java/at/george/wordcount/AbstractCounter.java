package at.george.wordcount;

public abstract class AbstractCounter {


    public int count(final String input) {
        return (int) prepareTheWords(input).filter(word -> !stopWords.contains(word))
                .count();
    }
}
