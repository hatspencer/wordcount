package wordcount;

import java.util.Collection;

public class FileUserInputReader implements UserInputReader {

	private final LinesReader linesReader;
	
	public FileUserInputReader(LinesReader linesReader) {
		this.linesReader = linesReader;
	}
	
	@Override
	public Collection<String> readUserInput() {
		return linesReader.readLines();
	}

}
