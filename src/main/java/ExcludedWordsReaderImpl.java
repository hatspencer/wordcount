import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExcludedWordsReaderImpl implements ExcludedWordsReader
{
		
	private String fileName;
	
	public ExcludedWordsReaderImpl(String fileName) {
		this.fileName = fileName;
	}
	
	public List<String> readFromFile() {
		
		List<String> resultList = new ArrayList<String>();
			
		try(Stream<String> stream = Files.lines(Paths.get(fileName))) {
		// TODO implement result list logic	
			
		}
		catch (IOException exception) {
			exception.printStackTrace();			
		}
		
		return resultList;
		
	}
}
