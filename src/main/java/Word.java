public class Word implements Comparable{
    private String word;
    private boolean isKnown;

    Word(String word, boolean isKnown) {
        this.word = word;
        this.isKnown = isKnown;
    }

    boolean isKnown() {
        return isKnown;
    }

    String getWord() {
        return word;
    }

    void setWord(String word) {
        this.word = word;
    }

    void setKnown(boolean known) {
        isKnown = known;
    }

    @Override
    public String toString() {
        return word + ((isKnown)?"":"*");
    }

    @Override
    public int compareTo(Object o) {
        return word.toLowerCase().compareTo(((Word)o).word.toLowerCase());
    }

}
