package wordcount;

import java.util.Scanner;

public class WordCountMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		System.out.println("Enter text:");
		int wordCount = new WordCounter().countWordsInAString(in.nextLine());
		System.out.println("Number of words: "+ wordCount);
	}
}
