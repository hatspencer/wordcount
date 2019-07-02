package wordcount;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileLinesReader implements LinesReader {
	private final String fileName;
	
	public FileLinesReader(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public Collection<String> readLines() {
		final ClassLoader classLoader = getClass().getClassLoader();
		
		final URL fileUrl = classLoader.getResource(fileName);
		if(fileUrl == null) {
			throw new IllegalStateException(String.format("Given file was not found: %s", fileName));
		}
		
		URI fileUri = null;
		try {
			fileUri = fileUrl.toURI();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
			throw new IllegalStateException(e1.getMessage(), e1);
		}
		
		try (Stream<String> stream = Files.lines(Paths.get(fileUri))) {
			return stream.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException(e.getMessage(), e);
		}
	}
}
