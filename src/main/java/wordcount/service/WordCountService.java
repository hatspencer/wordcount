package wordcount.service;

import java.util.Arrays;

public class WordCountService {

	public static long getWordCount(String input) {
		if (input == null || input.length() == 0) {
			return 0;
		}
		return Arrays.stream(input.split("\\s+")).filter(w -> w.matches("[a-zA-Z]+")).count();
	}
	
}
