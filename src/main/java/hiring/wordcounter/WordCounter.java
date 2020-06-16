package hiring.wordcounter;

import java.util.Set;

public interface WordCounter {
	WordCounterResult countWords(String inputText);
	WordCounterResult countWords(String inputText, Set<String> stopWords);
}
