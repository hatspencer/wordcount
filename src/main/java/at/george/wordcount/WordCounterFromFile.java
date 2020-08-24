package at.george.wordcount;

public class WordCounterFromFile extends AbstractCounter {

    public int countFromFile(final String pathToFile) {
        final String words = reader.asString(pathToFile);
        return (int) super.prepareTheWords(words)
                .filter(word -> !stopWords.contains(word))
                .count();
    }
}
