package hiring.stopwords;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordsParserImpl implements StopWordsParser {

	public Set<String> parseStopWords(String stopWordsInput) {
		return Arrays.stream(stopWordsInput.split("\\n"))
				.map(String::trim)
				.filter(stopWord -> stopWord.length() > 0)
				.collect(Collectors.toSet());
	}
}
