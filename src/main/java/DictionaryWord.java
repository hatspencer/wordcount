import java.util.Objects;

public class DictionaryWord {

    private final String word;
    private final boolean matched;

    public DictionaryWord(String word, boolean matched) {
        this.word = word;
        this.matched = matched;
    }

    public boolean isMatched() {
        return matched;
    }

    @Override
    public String toString() {
        return word + (matched ? "" : "*");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DictionaryWord that = (DictionaryWord) o;
        return matched == that.matched &&
                Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, matched);
    }
}
