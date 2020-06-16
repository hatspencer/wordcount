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
	public void GIVEN__WHEN__THEN_() {
		InputTextReader inputTextReader = mockInputTextReader();
		WordCounter wordCounter = createMockCounter();
		MockOutputPrinter outputPrinter = new MockOutputPrinter();

		App app = new App(inputTextReader, wordCounter, outputPrinter);
		app.run();

		assertEquals("Enter text: \nNumber of words: 5\n", outputPrinter.out);

	}

	private InputTextReader mockInputTextReader() {
		return new InputTextReader() {
			@Override
			public String readInputText() {
				return "";
			}
		};
	}

	private WordCounter createMockCounter() {
		return new WordCounter() {
			@Override
			public int countWords(String inputText) {
				return 5;
			}
		};
	}

	class MockOutputPrinter implements OutputPrinter {
		public String out = "";

		@Override
		public void print(String s) {
			out += s;
		}
	};

}