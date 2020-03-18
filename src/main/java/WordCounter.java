import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class WordCounter implements Counter {
	
	private final String fileName = "/wordcount/src/stopwords.txt";
	private String message;
	private List<String> excludedWords;
	private ExcludedWordsReader reader;
		
	
	//*
	public void setExcludedWords(List<String> excludedWords) {
		this.excludedWords = excludedWords;
	}
	//*/

	public List<String> getExcludedWords() {
		return excludedWords;
	}

	public WordCounter(String message) {
		if(message == null) throw new IllegalArgumentException("Ivalid argument: ");
		this.message = message;
		excludedWords = new ArrayList<String>();
		
		this.reader = new ExcludedWordsReaderImpl(fileName);
	}	
	
	public WordCounter(String message, ExcludedWordsReader reader) {
		if(message == null) throw new IllegalArgumentException("Ivalid argument: ");
		this.message = message;
		excludedWords = new ArrayList<String>();
		
		this.reader = reader;
	}	
	
	public int wordsCount() {				
		StringTokenizer st = new StringTokenizer(message);
		
		int count = 0;
		while(st.hasMoreTokens())
		{
			String token = st.nextToken();
			if(isCountable(token)) {
				
				count++;			   
			}
		}		
		return count;
	}
	
	private boolean isCountable(String token) {
		
		return token.matches("[a-zA-Z]+") &&
			   !excludedWords.contains(token);
	}
	
	private void readFromFile() {
		
		String text;
		try {
			text = new String(Files.readAllBytes(Paths.get(fileName)));
			excludedWords = Arrays.asList(text);
		}
		catch (IOException exception) {
			exception.printStackTrace();			
		}
	}	
	
}
