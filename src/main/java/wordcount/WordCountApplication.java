package wordcount;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import wordcount.service.WordCountService;

public class WordCountApplication {

	public static void main(String[] args) throws Exception {
		System.out.println("Enter text:");
		String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("Number of words: " + WordCountService.getWordCount(input));
	}
	
}
