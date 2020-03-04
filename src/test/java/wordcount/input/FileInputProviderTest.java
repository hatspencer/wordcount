package wordcount.input;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class FileInputProviderTest {
	
	@Test
	public void invalidFile() {
		String path = "invalidFile.txt";
		assertTrue(Files.notExists(Paths.get("invalidFile.txt")));
		FileInputProvider fileInputProvider = new FileInputProvider(path);
		try {
			fileInputProvider.getInput();
			fail();
		} catch (IOException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void validFile() throws IOException {
		Path path = Files.createTempFile("junit-temp", ".txt");
		
	}
	

}
