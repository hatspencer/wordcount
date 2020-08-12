package wordcount.wordcounter;

public class Statistic {

    private int wordCount;

    private int unique;

    public Statistic(int wordCount, int unique) {
        this.wordCount = wordCount;
        this.unique = unique;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getUnique() {
        return unique;
    }
}
