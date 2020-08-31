package bencody;

import java.util.List;

public class WordIndex {

    public final List<String> words;
    public final int unknownWordCount;

    public WordIndex(List<String> words, int unknownWordCount) {
        this.words = words;
        this.unknownWordCount = unknownWordCount;
    }
}
