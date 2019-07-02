package wordcount;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class StopWordsReaderTest {
	
	@Test
	public void textExistingFile() {
		StopWordsReader stopWordsReader = new StopWordsReader("stopwordstest.txt");
		Collection<String> stopWords = stopWordsReader.readStopWords();
		
		Assert.assertEquals(stopWords, Arrays.asList("the", "a"));
	}
	
	@Test
	public void textNotexistingFile() {
		StopWordsReader stopWordsReader = new StopWordsReader("nonexistingfile.txt");
		
		Assert.assertThrows(IllegalStateException.class, stopWordsReader::readStopWords);
	}
}
