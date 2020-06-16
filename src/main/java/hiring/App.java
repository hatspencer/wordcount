package hiring;

import hiring.filereader.FileContentReader;
import hiring.filereader.ResourceFileContentReader;
import hiring.inputreader.InputTextReader;
import hiring.inputreader.InputTextReaderFactory;
import hiring.outputprinter.OutputPrinter;
import hiring.outputprinter.SystemOutputPrinter;
import hiring.wordcounter.StopWordsParser;
import hiring.wordcounter.WordCounterImpl;
import hiring.wordcounter.WordCounter;
import hiring.wordcounter.WordCounterResult;

import java.util.Set;

public class App {

	private InputTextReader inputTextReader;
	private WordCounter wordCounter;
	private OutputPrinter outputPrinter;

	public App(InputTextReader inputTextReader,
	           WordCounter wordCounter,
	           OutputPrinter outputPrinter) {

		this.inputTextReader = inputTextReader;
		this.wordCounter = wordCounter;
		this.outputPrinter = outputPrinter;
	}

	public void run() {
		String inputText = inputTextReader.readInputText();

		Set<String> stopWords = loadStopWords();
		WordCounterResult wordCounterResult =  wordCounter.countWords(inputText, stopWords);

		outputPrinter.print("Number of words: " + wordCounterResult.getNumberOfWords());
		outputPrinter.print(", unique: " + wordCounterResult.getNumberOfUniqueWords() + "\n");
	}

	private Set<String> loadStopWords() {
		String stopWordsFileContent = new ResourceFileContentReader().readFileContent("stopwords.txt");
		Set<String> stopWords = new StopWordsParser().parseStopWords(stopWordsFileContent);
		return stopWords;
	}

	public static void main(String[] args) {
		AppArguments appArguments = new AppArguments(args);

		OutputPrinter outputPrinter = new SystemOutputPrinter();
		InputTextReader inputTextReader = InputTextReaderFactory.createInputTextReader(appArguments.getInputFileName());

		WordCounter wordCounter = new WordCounterImpl();

		App app = new App(inputTextReader, wordCounter, outputPrinter);
		app.run();
	}

}
