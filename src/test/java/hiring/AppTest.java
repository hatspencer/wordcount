package hiring;

import hiring.inputreader.InputTextReader;
import hiring.outputprinter.OutputPrinter;
import hiring.wordcounter.WordCounter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class AppTest {

	@Test
	public void WHEN_run_application_THEN_output_is_correct() {
		// when
		InputTextReader inputTextReader = mockInputTextReader();
		WordCounter wordCounter = createMockCounter();
		MockOutputPrinter outputPrinter = new MockOutputPrinter();

		App app = new App(inputTextReader, wordCounter, outputPrinter);
		app.run();

		// then
		assertEquals("Enter text: Number of words: 5\n", outputPrinter.out);
	}

	private InputTextReader mockInputTextReader() {
		return () -> "";
	}

	private WordCounter createMockCounter() {
		return inputText -> 5;
	}

	static class MockOutputPrinter implements OutputPrinter {
		public String out = "";

		@Override
		public void print(String s) {
			out += s;
		}
	}
}