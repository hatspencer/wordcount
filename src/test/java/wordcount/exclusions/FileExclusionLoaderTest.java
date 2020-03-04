package wordcount.exclusions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class FileExclusionLoaderTest {
	
	@Test
	public void nonExistingFile() {
		Path path = Paths.get("invalidFile.txt");
		assertTrue(Files.notExists(path));
		ExclusionLoader exclusionLoader = new FileExclusionLoader(path);
		assertEquals(0, exclusionLoader.loadExclusions().size());
	}
	
	@Test
	public void emptyFile() throws IOException {
		Path path = Files.createTempFile("junit-temp", ".txt");	    
		ExclusionLoader exclusionLoader = new FileExclusionLoader(path);
		assertEquals(0, exclusionLoader.loadExclusions().size());
	}
	
	@Test
	public void validFile() throws IOException {
		Path path = Files.createTempFile("junit-temp", ".txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile().getAbsolutePath()));
	    bw.write("the\n");
	    bw.write("file");
	    bw.close();
	    
		ExclusionLoader exclusionLoader = new FileExclusionLoader(path);
		assertEquals(2, exclusionLoader.loadExclusions().size());
	}
}
