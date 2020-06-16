package hiring;

import hiring.filereader.FileContentReader;
import hiring.inputreader.InputTextReader;
import hiring.outputprinter.OutputPrinter;
import hiring.stopwords.StopWordsParser;
import hiring.stopwords.StopWordsParserImpl;
import hiring.wordcounter.WordCounter;
import hiring.wordcounter.WordCounterResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class AppTest {

	@Test
	public void GIVEN_minimal_dependencies_WHEN_run_application_THEN_output_is_correct() {
		// given
		int expectedNumberOfWords = 2;
		String mockedInputText = "word word";

		InputTextReader inputTextReader = mockInputTextReader(mockedInputText);
		MockWordCounter wordCounter = new MockWordCounter(expectedNumberOfWords);
		MockOutputPrinter outputPrinter = new MockOutputPrinter();
		FileContentReader fileContentReader = createMockFileContentReader();
		StopWordsParser stopWordsParser = mockStopWordsParser(Collections.emptySet());

		// when
		App app = new App(inputTextReader, wordCounter, outputPrinter, fileContentReader, stopWordsParser);
		app.run();

		// then
		assertEquals("Number of words: " + expectedNumberOfWords + ", unique: 0\n", outputPrinter.out);
		assertEquals(mockedInputText, wordCounter.inputText);
	}

	@Test
	public void GIVEN_stop_words_provided_WHEN_run_application_THEN_stop_words_provided_to_word_counter() {
		// given
		int expectedNumberOfWords = 2;
		Set<String> mockedStopWords = new HashSet<>(Arrays.asList("best", "all", "not_in_input"));
		String mockedInputText = "word word";

		InputTextReader inputTextReader = mockInputTextReader(mockedInputText);
		MockWordCounter wordCounter = new MockWordCounter(expectedNumberOfWords);
		MockOutputPrinter outputPrinter = new MockOutputPrinter();
		FileContentReader fileContentReader = createMockFileContentReader();
		StopWordsParser stopWordsParser = mockStopWordsParser(mockedStopWords);

		// when
		App app = new App(inputTextReader, wordCounter, outputPrinter, fileContentReader, stopWordsParser);
		app.run();

		// then
		assertEquals("Number of words: " + expectedNumberOfWords + ", unique: 0\n", outputPrinter.out);
		assertEquals(mockedInputText, wordCounter.inputText);
		assertEquals(mockedStopWords, wordCounter.stopWords);
	}

	private FileContentReader createMockFileContentReader() {
		return fileName -> "";
	}

	private InputTextReader mockInputTextReader(String mockedInputText) {
		return () -> mockedInputText;
	}

	private StopWordsParser mockStopWordsParser(Set<String> mockedStopWords) {
		return stopWordsInput -> mockedStopWords;
	}

	static class MockWordCounter implements WordCounter {
		int mockedCountToReturn;
		String inputText;
		Set<String> stopWords;

		public MockWordCounter(int mockedCountToReturn) {
			this.mockedCountToReturn = mockedCountToReturn;
		}

		@Override
		public WordCounterResult countWords(String inputText) {
			return countWords(inputText, Collections.emptySet());
		}

		@Override
		public WordCounterResult countWords(String inputText, Set<String> stopWords) {
			this.inputText = inputText;
			this.stopWords = stopWords;
			WordCounterResult wordCounterResult = new WordCounterResult();
			wordCounterResult.setNumberOfWords(mockedCountToReturn);
			return wordCounterResult;
		}
	};

	static class MockOutputPrinter implements OutputPrinter {
		public String out = "";

		@Override
		public void print(String s) {
			out += s;
		}
	}
}