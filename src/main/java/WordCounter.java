import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;

public class WordCounter implements Counter {
	
	public static final String fileName = "/wordcount/src/stopwords.txt";
	private String message;
	private List<String> excludedWords;	
	private HashSet<String> uniqueWords;
	private List<String> allWords;
		
	public int getUniqueWordsCount() {
		return uniqueWords.size();
	}
	
	public double getAverageWordSize() {
		
		double result = 0.0;
		
		for(String word : allWords) {
			result += word.length();
		}
		
		int countOfWords = allWords.size();
	
		
		return countOfWords != 0 ? 
				result / countOfWords :
				0.0;
	}

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
		
		uniqueWords = new HashSet<String>();
		allWords = new ArrayList<String>();
	}	
	
	public int wordsCount() {		
				
		StringTokenizer st = new StringTokenizer(message);
		
		int count = 0;
		while(st.hasMoreTokens())
		{
			String token = st.nextToken();	
						
			token = removeDotFromString(token);
			
						
			if(isCountable(token)) {			
				addUniqueWordToUniqueWordsDictionary(token);
				allWords.add(token);
				count++;			   
			}
		}		
		return count;
	}

	private String removeDotFromString(String token) {
		if(token.endsWith(".")) {
			token = token.replace(".", "");
		}
		return token;
	}

	private void addUniqueWordToUniqueWordsDictionary(String token) {
		uniqueWords.add(token);		
	}
	
	
	private boolean isCountable(String token) {
		
		return token.matches("[a-zA-Z\\-]+") &&
			   !excludedWords.contains(token);
	}	
}
