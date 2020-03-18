import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {
	
	public static List<String> readFromFile(String fileName) {
		
		List<String> resultList = new ArrayList<String>();
			
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			while ((line = br.readLine()) != null) {
				resultList.add(line);				
			}
		}
		catch (IOException exception) {
			exception.printStackTrace();			
		}
		
		return resultList;
		
	}
}