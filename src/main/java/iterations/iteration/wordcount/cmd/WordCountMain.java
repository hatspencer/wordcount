package iterations.iteration.wordcount.cmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import iterations.iteration.wordcount.WordCount;
import iterations.iteration.wordcount.WordCountUnique;

public class WordCountMain {

	private static final String STOP_WORDS_DEFAULT_LOCATION = "stopwords.txt";

	public static void main(String[] args) {
		WordCount wordCount = new WordCount();
		WordCountUnique wordCountUnique = new WordCountUnique(wordCount);
		initStopWords(wordCount, STOP_WORDS_DEFAULT_LOCATION);
		
		String singleLine = null;
		
		if (args.length > 0) {
			singleLine = getTextFileContent(args[0]);
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			if (singleLine == null) {
				System.out.println("Enter text: ");
				singleLine = reader.readLine();
			}
			System.out.print("Number of words: ");
			System.out.print(wordCount.countWords(singleLine));
			System.out.print(", unique: ");
			System.out.println(wordCountUnique.countWords(singleLine));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Reading your command line input failed");
		}
	}
	
	private static String getTextFileContent(String fileName) {
		List<String> input = readLinesFromFile(fileName);
		if (input == null || input.isEmpty())
			return null;
		return String.join(" ", input);
	}
	
	/**
	 * 
	 * @param fileName
	 * @return null if file doesn't exist, otherwise the content (lines separated by 'nl' char)
	 */
	private static List<String> readLinesFromFile(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			LinkedList<String> lines = new LinkedList<String>();
			FileInputStream inputFileStream = null;
			try {
				inputFileStream = new FileInputStream(file);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputFileStream));
				String line;
				while((line = reader.readLine()) != null) {
					lines.add(line);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				if (inputFileStream != null) {
					try {
						inputFileStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return lines;
		}
		return null;
	}
	
	private static void initStopWords(WordCount wordCount, String stopWordsFileName) {
		List<String> stopWords = readLinesFromFile(stopWordsFileName);
		if (stopWords != null) {
			wordCount.addStopWords(stopWords);
		}
	}

}
