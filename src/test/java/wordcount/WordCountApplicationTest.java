package wordcount;

import org.junit.Assert;
import org.junit.Test;

public class WordCountApplicationTest {

	@Test
	public void testFile() {
		String existingFile = "pom.xml";
		String nonExistingFile = "123";
		Assert.assertEquals(true, WordCountApplication.fileIsReadable(existingFile));
		Assert.assertEquals(false, WordCountApplication.fileIsReadable(nonExistingFile));
	}
	
}
