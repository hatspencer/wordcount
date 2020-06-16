package hiring.filereader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ResourceFileContentReaderTest {

	FileContentReader resourceFileContentReader = new ResourceFileContentReader();

	@Test
	public void GIVEN_test_resource_file_WHEN_read_file_content_THEN_content_read_correctly() {
		// given
		String resourceFilename = "teststopwords.txt";

		// when
		String fileContent = resourceFileContentReader.readFileContent(resourceFilename);

		// then
		assertEquals("stopWord1\nstopWord2\nstopWord3\n", fileContent);
	}

}