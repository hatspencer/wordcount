package wordcount.input;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class FileInputProviderTest {
	
	@Test
	public void nonExistingFile() {
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
	public void emptyFile() throws IOException {
		Path path = Files.createTempFile("junit-temp", ".txt");
	    FileInputProvider fileInputProvider = new FileInputProvider(path);
	    String input = fileInputProvider.getInput();
	    assertEquals("", input);
	}
	
	@Test
	public void validFile() throws IOException {
		Path path = Files.createTempFile("junit-temp", ".txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile().getAbsolutePath()));
	    bw.write("This is temp\n");
	    bw.write("Another line");
	    bw.close();
	    FileInputProvider fileInputProvider = new FileInputProvider(path);
	    String input = fileInputProvider.getInput();
	    assertEquals("This is temp Another line", input);
	}
	

}
