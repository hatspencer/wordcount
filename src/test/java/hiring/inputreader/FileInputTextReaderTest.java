package hiring.inputreader;

import hiring.filereader.FileContentReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class FileInputTextReaderTest {

	@Test
	public void WHEN_read_input_text_THEN_proxied_to_file_content_reader() {
		// given
		MockedFileContentReader mockedFileContentReader = new MockedFileContentReader();

		// when
		FileInputTextReader fileInputTextReader = new FileInputTextReader("filename", mockedFileContentReader);
		fileInputTextReader.readInputText();

		// then
		assertTrue(mockedFileContentReader.wasCalled);
	}

	static class MockedFileContentReader implements FileContentReader {
		boolean wasCalled;

		@Override
		public String readFileContent(String fileName) {
			this.wasCalled = true;
			return null;
		}
	}

}