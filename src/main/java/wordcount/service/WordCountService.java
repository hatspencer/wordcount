package wordcount.service;

import java.util.Arrays;

public class WordCountService {

	public static long getWordCount(String input) {
		return Arrays.stream(input.split("\\s+")).filter(w -> w.matches("[a-zA-Z]+")).count();
	}
	
}
