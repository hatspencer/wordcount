package wordcount;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class FileLineReaderTest {
	
	@Test
	public void testExistingFile() {
		LinesReader fileLinesReader = new FileLinesReader("filelinetest.txt");
		Collection<String> stopWords = fileLinesReader.readLines();
		
		Assert.assertEquals(stopWords, Arrays.asList("the", "a"));
	}
	
	@Test
	public void testNotexistingFile() {
		LinesReader fileLinesReader = new FileLinesReader("nonexistingfile.txt");
		
		Assert.assertThrows(IllegalStateException.class, fileLinesReader::readLines);
	}
}
