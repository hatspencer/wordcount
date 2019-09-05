package at.flwal.erste;

import java.util.Set;
import java.util.regex.Pattern;

class WordCount {

	private static final Pattern WORD_SCHEMA = Pattern.compile("[A-Za-z]+");
	private static final String WORD_DELIMITER = "\\s+";

	private Set<String> stopwords;

	public WordCount(Set<String> stopwords) {

		if(stopwords == null) {
			throw new IllegalArgumentException("Stopwords list must not be null.");
		}

		this.stopwords = stopwords;
	}

	/**
	 * Count words (=combination of upper-& lower-case letters, exclusively)
	 * separated by one or more space (no other whitespaces are considered delimiters).
	 */
	int count(String text) {

		if(text == null) {
			return 0;
		}

		int count = 0;

		String[] candidates = text.split(WORD_DELIMITER);
		for (String candidate : candidates) {

			if(stopwords.contains(candidate)){
				continue;
			}

			boolean matches = WORD_SCHEMA.matcher(candidate).matches();
			if(matches){
				count++;
			}
		}

		return count;
	}

}
