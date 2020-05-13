package wordcount;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import wordcount.service.WordCountService;

public class WordCountApplication {

	public static void main(String[] args) throws Exception {
		if (args.length > 0 && fileIsReadable(args[0])) {
			getWordCountFromFile(args[0]);
		} else {
			getWordCountFromStandardInput();
		}
	}

	public static final boolean fileIsReadable(String input) {
		return Files.isReadable(Paths.get(input));
	}
	
	public static final void getWordCountFromFile(String filename) {
		long wordCount = WordCountService.getWordCountFromFile(filename);
		System.out.println("Number of words: " + wordCount);
	}
	
	public static final void getWordCountFromStandardInput() {
		System.out.println("Enter text:");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String input = reader.readLine();
			System.out.println("Number of words: " + WordCountService.getWordCount(input));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
}
