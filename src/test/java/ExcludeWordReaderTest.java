import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.List;
import org.junit.Test;


public class ExcludeWordReaderTest {
	
	public static final String fileName = "./src/stopwords.txt";
	
	@Test
	public void shouldReadFile() throws FileNotFoundException{
		
		WordsReader reader = new ExcludedWordsReaderImpl(fileName);
		
		List<String> result = reader.readFromFile();
		
		assertEquals(4, result.size());		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExcetionIfFileNameIsNull() throws FileNotFoundException {
		
		WordsReader reader = new ExcludedWordsReaderImpl(null);
		
		List<String> result = reader.readFromFile();		
			
	}
	
	@Test(expected = FileNotFoundException.class)
	public void shouldThrowExcetionIfFileNameIsWrong() throws FileNotFoundException{
		
		WordsReader reader = new ExcludedWordsReaderImpl("abcde.txt");
		
		List<String> result = reader.readFromFile();		
			
	}

}
