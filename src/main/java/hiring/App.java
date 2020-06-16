package hiring;

import hiring.inputreader.InputTextReader;
import hiring.inputreader.SystemInputTextReader;
import hiring.outputprinter.OutputPrinter;
import hiring.outputprinter.SystemOutputPrinter;
import hiring.filereader.FileContentReader;
import hiring.filereader.ResourceFileContentReader;
import hiring.wordcounter.SimpleStopWordsParser;
import hiring.wordcounter.StopWordsParser;
import hiring.wordcounter.WordCounter;
import hiring.wordcounter.RegexpWordCounter;

import java.util.Collections;
import java.util.Set;

public class App {

	private InputTextReader inputTextReader;
	private WordCounter wordCounter;
	private OutputPrinter outputPrinter;
	private FileContentReader fileContentReader;
	private StopWordsParser stopWordsLoader;

	public App(InputTextReader inputTextReader,
	           WordCounter wordCounter,
	           OutputPrinter outputPrinter) {

		this.inputTextReader = inputTextReader;
		this.wordCounter = wordCounter;
		this.outputPrinter = outputPrinter;
	}

	public void run() {
		outputPrinter.print("Enter text: ");
		String inputText = inputTextReader.readInputText();

		int wordCount;
		Set<String> stopWords = loadStopWordsIfNeeded();
		if (!stopWords.isEmpty()) {
			wordCount = wordCounter.countWords(inputText, stopWords);
		} else {
			wordCount = wordCounter.countWords(inputText);
		}

		outputPrinter.print("Number of words: ");
		outputPrinter.print(wordCount + "\n");
	}

	private Set<String> loadStopWordsIfNeeded() {
		if (stopWordsLoader == null || fileContentReader == null) {
			return Collections.emptySet();
		} else {
			String stopWordsFileContent = fileContentReader.readFileContent("stopwords.txt");
			Set<java.lang.String> stopWords = stopWordsLoader.parseStopWords(stopWordsFileContent);
			return stopWords;
		}
	}

	public void setStopWordsLoader(StopWordsParser stopWordsLoader) {
		this.stopWordsLoader = stopWordsLoader;
	}

	public void setFileContentReader(FileContentReader fileContentReader) {
		this.fileContentReader = fileContentReader;
	}

	public static void main(String[] args) {
		InputTextReader inputTextReader = new SystemInputTextReader();
		WordCounter wordCounter = new RegexpWordCounter();
		OutputPrinter outputPrinter = new SystemOutputPrinter();
		FileContentReader fileContentReader = new ResourceFileContentReader();
		StopWordsParser stopWordsParser = new SimpleStopWordsParser();

		App app = new App(inputTextReader, wordCounter, outputPrinter);
		app.setStopWordsLoader(stopWordsParser);
		app.setFileContentReader(fileContentReader);

		app.run();
	}
}
