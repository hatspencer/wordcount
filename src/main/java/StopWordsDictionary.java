import java.util.Set;

public class StopWordsDictionary implements WordsDictionary {

    private final Set<String> stopWordsSet;

    public StopWordsDictionary(Set<String> stopWordsSet) {
        this.stopWordsSet = stopWordsSet;
    }

    @Override
    public boolean containsWord(String word) {
        return word != null && stopWordsSet.contains(word);
    }
}
