import java.util.List;
import java.util.StringTokenizer;

public class WordCounter implements Counter {
	
	public static final String fileName = "/wordcount/src/stopwords.txt";
	private String message;
	private List<String> excludedWords;	
		
	public void setExcludedWords(List<String> excludedWords) {
		this.excludedWords = excludedWords;
	}	

	public List<String> getExcludedWords() {
		return excludedWords;
	}
	
	
	public WordCounter(String message, List<String> excludedWords) {
		if(message == null) throw new IllegalArgumentException("Ivalid argument: ");
		this.message = message;				
		this.excludedWords = excludedWords;			
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
}
