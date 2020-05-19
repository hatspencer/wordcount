import java.util.Set;

public class HashWordsDictionary implements WordsDictionary {

    private final Set<String> stopWordsSet;

    public HashWordsDictionary(Set<String> stopWordsSet) {
        this.stopWordsSet = stopWordsSet;
    }

    @Override
    public boolean containsWord(String word) {
        return word != null && stopWordsSet.contains(word);
    }

    public boolean isEmpty() {
        return stopWordsSet.isEmpty();
    }
}
