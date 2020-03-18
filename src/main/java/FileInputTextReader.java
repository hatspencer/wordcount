import java.util.ArrayList;
import java.util.List;

public class FileInputTextReader implements WordsReader {
	
	private String fileName;
	
	public FileInputTextReader(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public List<String> readFromFile() {
		if(fileName == null) return new ArrayList<String>();
		return Utils.readFromFile(fileName);
	}

}
