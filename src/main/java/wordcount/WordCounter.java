package wordcount;

import java.util.Arrays;
import java.util.Scanner;

public class WordCounter {

	private static final String WHITE_SPACE_REGEX = "\\s+";
	private static final String ONLY_LETTERS_REGEX = "[a-zA-Z]+";

	public long countWordsOf(String text) {
		String[] split = text.split(WHITE_SPACE_REGEX);

		return Arrays.stream(split)
				.filter(each -> each.matches(ONLY_LETTERS_REGEX))
				.count();
	}
}
