package hiring;

import hiring.filereader.FileContentReader;
import hiring.inputreader.InputTextReader;
import hiring.outputprinter.OutputPrinter;
import hiring.stopwords.StopWordsParser;
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
	public void GIVEN_mocked_results_WHEN_run_application_THEN_output_is_correct() {
		// given
		int expectedNumberOfWords = 2;
		int expectedNumberOfUniqueWords = 5;
		int expectedAverageLength = 6;
		String mockedInputText = "word word";

		InputTextReader inputTextReader = mockInputTextReader(mockedInputText);
		MockWordCounter wordCounter = new MockWordCounter(expectedNumberOfWords, expectedNumberOfUniqueWords, expectedAverageLength);
		MockOutputPrinter outputPrinter = new MockOutputPrinter();
		FileContentReader fileContentReader = createMockFileContentReader();
		StopWordsParser stopWordsParser = mockStopWordsParser(Collections.emptySet());

		// when
		App app = new App(inputTextReader, wordCounter, outputPrinter, fileContentReader, stopWordsParser);
		app.run();

		// then
		assertEquals("Number of words: 2, unique: 5; average word length: 6.0 characters\n", outputPrinter.out);
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
		int mockedCount;
		int mockedUniqueCount;
		double mockedAverageLength;
		String inputText;
		Set<String> stopWords;

		public MockWordCounter(int mockedCount) {
			this(mockedCount, 0, 0D);
		}

		public MockWordCounter(int mockedCount, int mockedUniqueCount, double mockedAverageLength) {
			this.mockedCount = mockedCount;
			this.mockedUniqueCount = mockedUniqueCount;
			this.mockedAverageLength = mockedAverageLength;
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
			wordCounterResult.setNumberOfWords(mockedCount);
			wordCounterResult.setNumberOfUniqueWords(mockedUniqueCount);
			wordCounterResult.setAverageWordLength(mockedAverageLength);
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