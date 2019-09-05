package at.flwal.erste;

import java.util.regex.Pattern;

class WordCount {

	private static final Pattern WORD_SCHEMA = Pattern.compile("[A-Za-z]+");
	private static final String WORD_DELIMITER = "\\s+";

	/**
	 * Count words (=combination of upper-& lower-case letters, exclusively)
	 * separated by one or more space (no other whitespaces are considered delimiters).
	 */
	static int count(String text) {

		if(text == null) {
			return 0;
		}

		int count = 0;

		String[] candidates = text.split(WORD_DELIMITER);
		for (String candidate : candidates) {
			boolean matches = WORD_SCHEMA.matcher(candidate).matches();
			if(matches){
				count++;
			}
		}

		return count;
	}

}
