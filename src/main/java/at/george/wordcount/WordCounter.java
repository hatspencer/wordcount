package at.george.wordcount;

public class WordCounter extends AbstractCounter {

    private final Preparer preparer = new Preparer();

    public int count(final String input) {
        return (int) preparer.prepareTheWords(input)
                .filter(word -> !stopWords.contains(word))
                .count();
    }
}
