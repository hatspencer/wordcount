package iterations.iteration.wordcount.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import iterations.iteration.wordcount.WordCount;

public class WordCountMain {

	public static void main(String[] args) {
		WordCount wordCount = new WordCount();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter text: ");
		try {
			String singleLine = reader.readLine();
			System.out.print("Number of words: ");
			System.out.println(wordCount.countWords(singleLine));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Reading your command line input failed");
		}
	}

}
