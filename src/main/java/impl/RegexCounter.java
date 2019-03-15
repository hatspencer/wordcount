package impl;

import api.WordCounter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCounter implements WordCounter {

	// requirements unclear for word boundary, assumption to use regex pattern \b
	private static final Pattern pattern = Pattern.compile("\\b[a-zA-Z]+\\b");

	public int count(String input) {
		if (input == null) {
			return 0;
		}

		Matcher matcher = pattern.matcher(input);
		int count = 0;
		while (matcher.find()) {
			count++;
		}

		return count;
	}
}