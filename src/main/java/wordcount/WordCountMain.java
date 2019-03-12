package wordcount;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import input.FileIO;

public class WordCountMain {

	public static void main(String[] args) throws IOException {
		List<String> stopWords = FileIO.readFile("Stopwords.txt");
		Scanner in = new Scanner(System.in); 
		System.out.println("Enter text:");
		int wordCount = new WordCounter().countWordsInAString(in.nextLine(), stopWords);
		System.out.println("Number of words: "+ wordCount);
	}
}
