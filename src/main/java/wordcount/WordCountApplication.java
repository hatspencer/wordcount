package wordcount;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import wordcount.dto.WordCountResult;
import wordcount.service.WordCountService;

public class WordCountApplication {

	public static void main(String[] args) throws Exception {
		Set<String> stopWords = WordCountService.getStopWords(Paths.get("stopwords.txt"));
		if (args.length > 0 && fileIsReadable(args[0])) {
			WordCountResult result = WordCountService.getResult(Paths.get(args[0]), stopWords);
			System.out.println("Number of words: " + result.getWordCount() + ", unique: " + result.getWordCountUnique());
		} else {
			System.out.println("Enter text:");
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
				String input = reader.readLine();
				WordCountResult result = WordCountService.getResult(WordCountService.getStream(input), stopWords);
				System.out.println("Number of words: " + result.getWordCount() + ", unique: " + result.getWordCountUnique());
			} catch (Exception e) {
			}
		}
	}

	public static final boolean fileIsReadable(String input) {
		return Files.isReadable(Paths.get(input));
	}
	
}
