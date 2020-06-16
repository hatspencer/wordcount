package hiring;

import hiring.filereader.FileContentReader;
import hiring.inputreader.InputTextReader;
import hiring.outputprinter.OutputPrinter;
import hiring.wordcounter.StopWordsParser;
import hiring.wordcounter.WordCounter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
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

		// when
		App app = new App(inputTextReader, wordCounter, outputPrinter);
		app.run();

		// then
		assertEquals("Number of words: " + expectedNumberOfWords + "\n", outputPrinter.out);
		assertEquals(mockedInputText, wordCounter.inputText);
	}

	@Test
	public void GIVEN_stop_words_parser_provided_WHEN_run_application_THEN_output_is_correct() {
		// given
		int expectedNumberOfWords = 2;
		Set<String> mockedStopWords = new HashSet<>(Arrays.asList("best", "all", "not_in_input"));
		String mockedInputText = "word word";

		InputTextReader inputTextReader = mockInputTextReader(mockedInputText);
		MockWordCounter wordCounter = new MockWordCounter(expectedNumberOfWords);
		MockOutputPrinter outputPrinter = new MockOutputPrinter();
		FileContentReader fileContentReader = createMockFileContentReader();
		StopWordsParser stopWordsLoader = createMockStopWordsParser(mockedStopWords);

		// when
		App app = new App(inputTextReader, wordCounter, outputPrinter);
		app.setFileContentReader(fileContentReader);
		app.setStopWordsLoader(stopWordsLoader);
		app.run();

		// then
		assertEquals("Number of words: " + expectedNumberOfWords + "\n", outputPrinter.out);
		assertEquals(mockedInputText, wordCounter.inputText);
		assertEquals(mockedStopWords, wordCounter.stopWords);
	}

	private StopWordsParser createMockStopWordsParser(Set<String> mockedStopWords) {
		return stopWordsInput -> mockedStopWords;
	}

	private FileContentReader createMockFileContentReader() {
		return fileName -> "";
	}

	private InputTextReader mockInputTextReader(String mockedInputText) {
		return () -> mockedInputText;
	}

	static class MockWordCounter implements WordCounter {
		int mockedCountToReturn;
		String inputText;
		Set<String> stopWords;

		public MockWordCounter(int mockedCountToReturn) {
			this.mockedCountToReturn = mockedCountToReturn;
		}

		@Override
		public int countWords(String inputText) {
			return mockedCountToReturn;
		}

		@Override
		public int countWords(String inputText, Set<String> stopWords) {
			this.inputText = inputText;
			this.stopWords = stopWords;
			return mockedCountToReturn;
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