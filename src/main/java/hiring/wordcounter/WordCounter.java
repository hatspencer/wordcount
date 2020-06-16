package hiring.wordcounter;

import java.util.Set;

public interface WordCounter {
	int countWords(String inputText);
	int countWords(String inputText, Set<String> stopWords);
}
