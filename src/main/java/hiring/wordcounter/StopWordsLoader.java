package hiring.wordcounter;

import hiring.resourcereader.FileContentReader;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class StopWordsLoader {

	private FileContentReader fileContentReader;

	public StopWordsLoader(FileContentReader fileContentReader) {
		this.fileContentReader = fileContentReader;
	}

	public Set<String> loadStopWords(String fileName) {
		String fileContent = fileContentReader.readFileContent(fileName);
		return Arrays.stream(fileContent.split("\\n"))
				.collect(Collectors.toSet());
	}
}
