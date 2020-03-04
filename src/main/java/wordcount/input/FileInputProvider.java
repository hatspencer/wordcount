package wordcount.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInputProvider implements InputProvider {
	
	private Path path;

	public FileInputProvider(Path path) {
		this.path = path;
	}
	
	public FileInputProvider(String pathString) {
		this.path = Paths.get(pathString);
	}

	@Override
	public String getInput() throws IOException {
		StringBuffer sb = new StringBuffer();
		Files.lines(path).forEach(line -> sb.append(line + " "));
		return sb.toString();
	}
	
}
