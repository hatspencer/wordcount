public class Word {
    private String word;
    private boolean isKnown;

    public Word(String word) {
        this.word = word;
    }

    public boolean isKnown() {
        return isKnown;
    }

    public void setKnown(boolean known) {
        isKnown = known;
    }

    @Override
    public String toString() {
        return word + ((isKnown)?"":"*");
    }
}
