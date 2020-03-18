import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExcludedWordsReaderImpl implements ExcludedWordsReader
{
		
	private String fileName;
	
	public ExcludedWordsReaderImpl(String fileName) throws FileNotFoundException {
		if(fileName == null) throw new IllegalArgumentException("Missing fileName");
		if(!Files.exists(Paths.get(fileName))) throw new FileNotFoundException("File Not found: ");
		
		this.fileName = fileName;
	}
	
	public List<String> readFromFile() {
		
		List<String> resultList = new ArrayList<String>();
			
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			while ((line = br.readLine()) != null) {
				resultList.add(line.trim());				
			}
		}
		catch (IOException exception) {
			exception.printStackTrace();			
		}
		
		return resultList;
		
	}
}
