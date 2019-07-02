package wordcount;

import java.util.Scanner;

public class Start {
	public static void main(String[] args) {
		System.out.print("Enter text:");

		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		scanner.close();

		long wordCount = new WordCounter().countWordsOf(line);
		System.out.println(String.format("Number of words: %d", wordCount));
	}
}
