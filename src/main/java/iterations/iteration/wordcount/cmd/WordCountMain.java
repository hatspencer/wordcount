package iterations.iteration.wordcount.cmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import iterations.iteration.wordcount.WordCount;

public class WordCountMain {

	private static final String STOP_WORDS_DEFAULT_LOCATION = "stopwords.txt";

	public static void main(String[] args) {
		WordCount wordCount = new WordCount();
		initStopWords(wordCount, STOP_WORDS_DEFAULT_LOCATION);
		
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
	
	private static void initStopWords(WordCount wordCount, String stopWordsFileName) {
		File stopWordsFile = new File(stopWordsFileName);
		if (stopWordsFile.exists()) {
			FileInputStream inputFileStream = null;
			try {
				inputFileStream = new FileInputStream(stopWordsFile);
				BufferedReader stopWordsReader = new BufferedReader(new InputStreamReader(inputFileStream));
				String stopWord;
				while((stopWord = stopWordsReader.readLine()) != null) {
					wordCount.addStopWords(stopWord);
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
		}
	}

}
