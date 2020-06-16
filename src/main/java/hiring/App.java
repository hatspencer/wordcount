package hiring;

import hiring.filereader.FileContentReader;
import hiring.filereader.ResourceFileContentReader;
import hiring.inputreader.InputTextReader;
import hiring.inputreader.InputTextReaderFactory;
import hiring.outputprinter.OutputPrinter;
import hiring.outputprinter.SystemOutputPrinter;
import hiring.wordcounter.RegexpWordCounter;
import hiring.wordcounter.SimpleStopWordsParser;
import hiring.wordcounter.StopWordsParser;
import hiring.wordcounter.WordCounter;

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

		Set<String> stopWords = loadStopWordsIfNeeded();
		int wordCount = wordCounter.countWords(inputText, stopWords);

		outputPrinter.print("Number of words: ");
		outputPrinter.print(wordCount + "\n");
	}

	private Set<String> loadStopWordsIfNeeded() {
		if (stopWordsLoader == null || fileContentReader == null) {
			return Collections.emptySet();
		} else {
			String stopWordsFileContent = fileContentReader.readFileContent("stopwords.txt");
			Set<String> stopWords = stopWordsLoader.parseStopWords(stopWordsFileContent);
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
		AppArguments appArguments = new AppArguments(args);

		InputTextReader inputTextReader = InputTextReaderFactory.createInputTextReader(appArguments.getInputFileName());
		OutputPrinter outputPrinter = new SystemOutputPrinter();
		WordCounter wordCounter = new RegexpWordCounter();
		FileContentReader fileContentReader = new ResourceFileContentReader();
		StopWordsParser stopWordsParser = new SimpleStopWordsParser();

		App app = new App(inputTextReader, wordCounter, outputPrinter);
		app.setStopWordsLoader(stopWordsParser);
		app.setFileContentReader(fileContentReader);

		app.run();
	}

}
