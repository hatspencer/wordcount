package at.george.wordcount;

import java.util.List;

public class WordCountService {

    public static final String STOP_WORDS_TXT = "stopwords.txt";
    protected final FileReader reader = new FileReader();
    protected final List<String> stopWords = reader.asList(STOP_WORDS_TXT);
    private final WordCounter wordCounter = new WordCounter(new InputPreparer(stopWords));

    public int count(final String userInput) {
        return wordCounter.count(userInput);
    }

    public int countFromPath(final String pathToFile) {
        final String words = reader.asString(pathToFile);
        return wordCounter.count(words);
    }
}
