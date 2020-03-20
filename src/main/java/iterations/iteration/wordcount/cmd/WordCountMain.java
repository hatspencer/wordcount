package iterations.iteration.wordcount.cmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import iterations.iteration.wordcount.WordCount;
import iterations.iteration.wordcount.WordCountUnique;

public class WordCountMain {

	private static final String STOP_WORDS_DEFAULT_LOCATION = "stopwords.txt";

	private DecimalFormat df2Places = new DecimalFormat("#.##");

	public static void main(String[] args) {
		new WordCountMain().run(args);
	}
	
	String singleLine = null;
	WordCount wordCount;
	WordCountUnique wordCountUnique;
	
	public void run(String[] inputArgs) {
		init();
		
		if (inputArgs.length > 0) {
			singleLine = getTextFileContent(inputArgs[0]);
		}
		try {
			if (singleLine == null) {
				requestInput();
			}
			countAndWriteOutput();
			printIndex();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Reading your command line input failed");
		}
	}
	
	public void init() {
		createWordCount();
		wordCountUnique = new WordCountUnique(wordCount);
	}
	
	private void countAndWriteOutput() {
		System.out.print("Number of words: ");
		System.out.print(wordCount.countWords(singleLine));
		System.out.print(", unique: ");
		System.out.print(wordCountUnique.countWords(singleLine));
		System.out.print("; average word length: ");
		System.out.print(df2Places.format(wordCount.averageWordLength(singleLine)));
		System.out.println(" characters");
	}
	
	private void printIndex() {
		List<String> uniqueWords = getIndex();
		System.out.println("Index:");
		for (String word : uniqueWords) {
			System.out.println(word);
		}
	}

	public List<String> getIndex() {
		List<String> uniqueWords = wordCountUnique.collectValidWords(singleLine);
		Collections.sort(uniqueWords, String::compareToIgnoreCase);
		return uniqueWords;
	}
	
	private void requestInput() throws IOException {
		System.out.println("Enter text: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		singleLine = reader.readLine();
	}
	
	public WordCount createWordCount() {
		wordCount = new WordCount();
		wordCount.setValidWordExp("[a-zA-Z\\-]+");
		wordCount.setWordsSeparator("[ ,\\t, \\.]+");
		initStopWords(wordCount, STOP_WORDS_DEFAULT_LOCATION);
		return wordCount;
	}
	
	private String getTextFileContent(String fileName) {
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
	private List<String> readLinesFromFile(String fileName) {
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
	
	private void initStopWords(WordCount wordCount, String stopWordsFileName) {
		List<String> stopWords = readLinesFromFile(stopWordsFileName);
		if (stopWords != null) {
			wordCount.addStopWords(stopWords);
		}
	}

}
