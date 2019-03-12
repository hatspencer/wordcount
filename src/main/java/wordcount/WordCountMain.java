package wordcount;

import java.io.IOException;
import java.util.List;

import input.ConsoleIO;
import input.FileIO;

public class WordCountMain {

	public static void main(String[] args) throws IOException {
		List<String> stopWords = FileIO.readFile("Stopwords.txt");
		int wordCount = new WordCounter().countWordsInAString(ConsoleIO.getUserInput(), stopWords);
		ConsoleIO.printResult(wordCount);
	}
}
