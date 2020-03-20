package iterations.iteration.wordcount.io;

import java.util.List;

public class TextConfigurationReader implements IConfigurationReader {

	final ITextResourceReader textResourceReader;
	
	public TextConfigurationReader(ITextResourceReader trr) {
		this.textResourceReader = trr;
	}
	
	@Override
	public List<String> readStopWords() {
		return textResourceReader.readLines();
	}

}
