package wordcount.stopwords;

import java.util.List;

public class StopWords {

    List<String> stopWords;

    public void setStopWords(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public boolean isStopWord(String word) {
        return stopWords.contains(word);
    }
}
