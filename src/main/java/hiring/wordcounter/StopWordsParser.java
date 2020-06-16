package hiring.wordcounter;

import java.util.Set;

public interface StopWordsParser {
	Set<String> parseStopWords(String stopWordsInput);
}
