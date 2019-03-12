package input;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileIO {
	
	public static List<String> readFile(String filename) throws IOException {
         Path path = FileSystems.getDefault().getPath( filename).toAbsolutePath();
		 return Files.readAllLines(path);
	}

}
