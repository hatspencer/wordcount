package hiring;

import hiring.inputreader.InputTextReader;
import hiring.inputreader.InputTextReaderScanner;
import hiring.outputprinter.OutputPrinter;
import hiring.outputprinter.OutputPrinterSout;
import hiring.resourcereader.FileContentReader;
import hiring.resourcereader.ResourceFileContentReader;
import hiring.wordcounter.StopWordsLoader;
import hiring.wordcounter.WordCounter;
import hiring.wordcounter.RegexpWordCounter;

import java.util.Set;

public class App {

	private InputTextReader inputTextReader;
	private WordCounter wordCounter;
	private OutputPrinter outputPrinter;
	private StopWordsLoader stopWordsLoader;

	public App(InputTextReader inputTextReader,
	           WordCounter wordCounter,
	           OutputPrinter outputPrinter) {

		this.inputTextReader = inputTextReader;
		this.wordCounter = wordCounter;
		this.outputPrinter = outputPrinter;
	}

	public void setStopWordsLoader(StopWordsLoader stopWordsLoader) {
		this.stopWordsLoader = stopWordsLoader;
	}

	public void run() {
		outputPrinter.print("Enter text: ");
		String inputText = inputTextReader.readInputText();

		int wordCount;
		if (stopWordsLoader != null) {
			Set<String> stopWords = stopWordsLoader.loadStopWords("stopwords.txt");
			wordCount = wordCounter.countWords(inputText, stopWords);
		} else {
			wordCount = wordCounter.countWords(inputText);
		}

		outputPrinter.print("Number of words: ");
		outputPrinter.print(wordCount + "\n");
	}

	public static void main(String[] args) {
		InputTextReader inputTextReader = new InputTextReaderScanner();
		WordCounter wordCounter = new RegexpWordCounter();
		OutputPrinter outputPrinter = new OutputPrinterSout();
		FileContentReader fileContentReader = new ResourceFileContentReader();
		StopWordsLoader stopWordsLoader = new StopWordsLoader(fileContentReader);

		App app = new App(inputTextReader, wordCounter, outputPrinter);
		app.setStopWordsLoader(stopWordsLoader);

		app.run();
	}
}
