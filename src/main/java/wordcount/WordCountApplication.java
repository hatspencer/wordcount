package wordcount;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Collections;

import wordcount.service.WordCountService;
import wordcount.service.WordExclusionComponent;

public class WordCountApplication {

	public static void main(String[] args) throws Exception {
		WordExclusionComponent wordExclusionComponent;
		try {
			wordExclusionComponent = new WordExclusionComponent(Paths.get("stopwords.txt"));
		} catch (Exception e) {
			wordExclusionComponent = new WordExclusionComponent(Collections.emptyList());
		}
		System.out.println("Enter text:");
		String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("Number of words: " + WordCountService.getWordCount(input, wordExclusionComponent));
	}

}
