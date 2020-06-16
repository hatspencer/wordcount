package hiring.filereader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TextFileContentReaderTest {

	TextFileContentReader textFileContentReader = new TextFileContentReader();

	@Test
	public void GIVEN_absolute_path_to_resource_file_WHEN_read_file_content_THEN_content_read_correctly() throws URISyntaxException {
		// given
		URL res = getClass().getClassLoader().getResource("teststopwords.txt");
		File file = Paths.get(res.toURI()).toFile();
		String absolutePath = file.getAbsolutePath();

		// when
		String fileContent = textFileContentReader.readFileContent(absolutePath);

		// then
		assertEquals("stopWord1\nstopWord2\nstopWord3\n", fileContent);
	}

}