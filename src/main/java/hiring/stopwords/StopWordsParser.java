package hiring.stopwords;

import java.util.Set;

public interface StopWordsParser {
	Set<String> parseStopWords(String stopWordsInput);
}
