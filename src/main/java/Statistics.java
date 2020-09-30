import java.util.Set;

public class Statistics {

    private int uniqueWordCount;
    private int allWordCount;
    private double averageLength;
    private Set<String> allUniqueWords;

    public int getUniqueWordCount() {
        return uniqueWordCount;
    }

    public void setUniqueWordCount(int uniqueWordCount) {
        this.uniqueWordCount = uniqueWordCount;
    }

    public int getAllWordCount() {
        return allWordCount;
    }

    public void setAllWordCount(int allWordCount) {
        this.allWordCount = allWordCount;
    }

    public double getAverageLength() {
        return averageLength;
    }

    public void setAverageLength(double averageLength) {
        this.averageLength = averageLength;
    }

    public Set<String> getAllUniqueWords() {
        return allUniqueWords;
    }

    public void setAllUniqueWords(Set<String> allUniqueWords) {
        this.allUniqueWords = allUniqueWords;
    }
}
