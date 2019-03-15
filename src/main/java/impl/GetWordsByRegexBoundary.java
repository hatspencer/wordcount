package impl;

import api.WordsProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetWordsByRegexBoundary implements WordsProvider {

	// requirements unclear for word boundary, assumption to use regex pattern \b
	private static final Pattern pattern = Pattern.compile("[a-zA-Z]+");

	@Override
	public Collection<String> getWords(String input) {
		if (input == null) {
			return Collections.emptyList();
		}

		List<String> words = new ArrayList<>();

		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			words.add(matcher.group());
		}

		return words;
	}
}