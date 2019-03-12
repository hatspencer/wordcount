package wordcount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import input.FileIO;

public class FileIOTest {
	
	public static final String TEST_FILE_NAME = "stopwordsTestFile.txt";
	public static final String NON_EXISTING_FILE_NAME = "NoFile.txt";
	public static final List<String> TEST_STOPWORDS_LIST = Arrays.asList("the","a","on","off");
	
	@Test
	public void testReadFileReturnsWordList() {
		List<String> actualStopwordsList = FileIO.readFile(TEST_FILE_NAME);
		assertEquals(TEST_STOPWORDS_LIST, actualStopwordsList);
	}

	@Test
	public void testReadFileReturnsEmptyListWhenFileNotExist() {
		List<String> actualStopwordsList = FileIO.readFile(NON_EXISTING_FILE_NAME);
		assertTrue(actualStopwordsList.isEmpty());
	}
}

	
