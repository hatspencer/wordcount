package hiring;

import hiring.filereader.FileContentReader;
import hiring.filereader.ResourceFileContentReader;
import hiring.inputreader.InputTextReader;
import hiring.inputreader.InputTextReaderFactory;
import hiring.outputprinter.OutputPrinter;
import hiring.outputprinter.SystemOutputPrinter;
import hiring.stopwords.StopWordsParser;
import hiring.stopwords.StopWordsParserImpl;
import hiring.wordcounter.WordCounterImpl;
import hiring.wordcounter.WordCounter;
import hiring.wordcounter.WordCounterResult;

import java.util.Set;

public class App {

	private InputTextReader inputTextReader;
	private WordCounter wordCounter;
	private OutputPrinter outputPrinter;
	private FileContentReader fileContentReader;
	private StopWordsParser stopWordsParser;

	public App(InputTextReader inputTextReader,
	           WordCounter wordCounter,
	           OutputPrinter outputPrinter,
	           FileContentReader fileContentReader,
	           StopWordsParser stopWordsParser) {

		this.inputTextReader = inputTextReader;
		this.wordCounter = wordCounter;
		this.outputPrinter = outputPrinter;
		this.fileContentReader = fileContentReader;
		this.stopWordsParser = stopWordsParser;
	}

	public void run() {
		String inputText = inputTextReader.readInputText();

		Set<String> stopWords = loadStopWords();
		WordCounterResult wordCounterResult =  wordCounter.countWords(inputText, stopWords);

		outputPrinter.print("Number of words: " + wordCounterResult.getNumberOfWords());
		outputPrinter.print(", unique: " + wordCounterResult.getNumberOfUniqueWords() + "\n");
	}

	private Set<String> loadStopWords() {
		String stopWordsFileContent = fileContentReader.readFileContent("stopwords.txt");
		Set<String> stopWords = stopWordsParser.parseStopWords(stopWordsFileContent);
		return stopWords;
	}

	public static void main(String[] args) {
		AppArguments appArguments = new AppArguments(args);

		InputTextReader inputTextReader = InputTextReaderFactory.createInputTextReader(appArguments.getInputFileName());
		WordCounter wordCounter = new WordCounterImpl();
		OutputPrinter outputPrinter = new SystemOutputPrinter();
		FileContentReader fileContentReader = new ResourceFileContentReader();
		StopWordsParserImpl stopWordsParser = new StopWordsParserImpl();

		App app = new App(inputTextReader,
				wordCounter,
				outputPrinter,
				fileContentReader,
				stopWordsParser);
		app.run();
	}

}
