package iterations.iteration.wordcount.io;

import java.util.List;

public interface ITextResourceReader {

	public String readContent();
	
	public List<String> readLines();
	
}
