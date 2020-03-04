package wordcount.exclusions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileExclusionLoader implements ExclusionLoader {

	Path path;
	
	public FileExclusionLoader(Path path) {
		this.path = path;
	}
	
	@Override
	public List<String> loadExclusions() {
		List<String> exclusions = new ArrayList<>();
		try {
			Files.lines(path).forEach(l -> exclusions.add(l.trim()));
		} catch (IOException e) {
			System.out.println("Error during exception loading on file " + path);
		}
		return exclusions;
	}

}
