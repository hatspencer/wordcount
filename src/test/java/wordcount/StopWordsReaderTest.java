package wordcount;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class StopWordsReaderTest {
	
	@Test
	public void textExistingFile() {
		StopWordsReader stopWordsReader = new StopWordsReader("stopwords.txt");
		Collection<String> stopWords = stopWordsReader.readStopWords();
		
		Assert.assertEquals(4, stopWords.size());
	}
}
