package wordcount;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class FileUserInputReaderTest {

	@Test
	public void testFileUserInputReader() {
		final Collection<String> lines = Arrays.asList("line1", "line2");
		final LinesReader linesReader = Mockito.mock(LinesReader.class);
		Mockito.when(linesReader.readLines()).thenReturn(lines);
		
		final UserInputReader userInputReader = new FileUserInputReader(linesReader);
		Assert.assertEquals(lines, userInputReader.readUserInput());
	}
}
