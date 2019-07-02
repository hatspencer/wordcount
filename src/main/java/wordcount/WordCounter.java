package wordcount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class WordCounter {

	private static final String WHITE_SPACE_REGEX = "\\s+";
	private static final String ONLY_LETTERS_REGEX = "[a-zA-Z]+";

	public static void main(String[] args) {
		System.out.print("Enter text:");

		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		scanner.close();

		long wordCount = new WordCounter().countWordsOf(line);
		System.out.println(String.format("Number of words: %d", wordCount));
	}

	public long countWordsOf(String text) {
		String[] split = text.split(WHITE_SPACE_REGEX);

		return Arrays.stream(split)
				.filter(each -> each.matches(ONLY_LETTERS_REGEX))
				.count();
	}
}
