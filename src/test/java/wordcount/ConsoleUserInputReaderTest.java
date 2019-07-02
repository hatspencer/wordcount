package wordcount;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

public class ConsoleUserInputReaderTest {
	
	@Test
	public void readUserInputReadsInputStream() {
		String userInput = "Humpty-Dumpty sat on a wall";
		String inputWithNewLine = userInput.concat("\n");
		InputStream inputStream = new ByteArrayInputStream(inputWithNewLine.getBytes(StandardCharsets.UTF_8));
		UserInputReader inputReader = new ConsoleUserInputReader(inputStream);
		
		Assert.assertEquals(Collections.singletonList(userInput), inputReader.readUserInput());
	}
}
