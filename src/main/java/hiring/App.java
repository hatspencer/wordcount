package hiring;

import hiring.inputreader.InputTextReader;
import hiring.inputreader.InputTextReaderScanner;
import hiring.outputprinter.OutputPrinter;
import hiring.outputprinter.OutputPrinterSout;
import hiring.wordcounter.WordCounter;
import hiring.wordcounter.WordCounterRegexp;

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
		outputPrinter.print("Enter text: ");
		String inputText = inputTextReader.readInputText();

		outputPrinter.print("Number of words: ");
		int wordCount = wordCounter.countWords(inputText);
		outputPrinter.print(wordCount + "\n");
	}

	public static void main(String[] args) {
		InputTextReader inputTextReader = new InputTextReaderScanner();
		WordCounter wordCounter = new WordCounterRegexp();
		OutputPrinter outputPrinter = new OutputPrinterSout();

		App app = new App(inputTextReader, wordCounter, outputPrinter);
		app.run();
	}
}
