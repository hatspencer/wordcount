package wordcount;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import wordcount.service.WordCountService;

public class WordCountApplication {

	public static void main(String[] args) throws Exception {
		if (args.length > 0 && Files.isReadable(Paths.get(args[0]))) {
			String filename = args[0];
			long wordCount = WordCountService.getWordCountFromFile(filename);
			System.out.println("Number of words: " + wordCount);
		} else {
			System.out.println("Enter text:");
			String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
			System.out.println("Number of words: " + WordCountService.getWordCount(input));
		}
	}

}
