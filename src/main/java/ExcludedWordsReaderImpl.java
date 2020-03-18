import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ExcludedWordsReaderImpl implements WordsReader
{
		
	private String fileName;

	public ExcludedWordsReaderImpl(String fileName) throws FileNotFoundException {
		if(fileName == null) throw new IllegalArgumentException("Missing fileName");
		if(!Files.exists(Paths.get(fileName))) throw new FileNotFoundException("File Not found: ");
		
		this.fileName = fileName;
	}
	
	public List<String> readFromFile() {
		
		return Utils.readFromFile(fileName);		
	}
}
