import java.util.Set;

public class StopWordsDictionary implements WordDictionary {

    private final Set<String> stopWordsDictionary;

    public StopWordsDictionary(Set<String> stopWordsDictionary) {
        this.stopWordsDictionary = stopWordsDictionary;
    }

    @Override
    public boolean containsWord(String word) {
        return word != null && stopWordsDictionary.contains(word);
    }
}
