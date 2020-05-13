package wordcount.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class WordExclusionComponent {

	private final Set<String> stopWords = new HashSet<>();
	
	public WordExclusionComponent(Path pathToFile) throws IOException {
		this(Files.readAllLines(pathToFile));
	}
	
	public WordExclusionComponent(Collection<String> stopWords) {
		this.stopWords.addAll(stopWords);
	}
	
	public boolean isWordExcluded(String word) {
		return stopWords.contains(word);
	}
	
}
