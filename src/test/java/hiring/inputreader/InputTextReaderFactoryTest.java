package hiring.inputreader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class InputTextReaderFactoryTest {

	@Test
	public void GIVEN_null_input_file_WHEN_create_input_text_reader_THEN_system_input_text_reader_created() {
		// given
		String inputFileName = null;

		// when
		InputTextReader inputTextReader = InputTextReaderFactory.createInputTextReader(inputFileName);

		// then
		assertTrue(inputTextReader instanceof SystemInputTextReader);
	}

	@Test
	public void GIVEN_input_file_WHEN_create_input_text_reader_THEN_file_input_text_reader_created() {
		// given
		String inputFileName = "filename";

		// when
		InputTextReader inputTextReader = InputTextReaderFactory.createInputTextReader(inputFileName);

		// then
		assertTrue(inputTextReader instanceof FileInputTextReader);
	}

}