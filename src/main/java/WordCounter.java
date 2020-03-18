import java.util.StringTokenizer;

public class WordCounter {
	
	private String message;
		
		
	public WordCounter(String message) {
		if(message == null) throw new IllegalArgumentException("Ivalid argument: ");
		this.message = message;
	}

	
	
	public int wordsCount() {				
		StringTokenizer st = new StringTokenizer(message);
		
		int count = 0;
		while(st.hasMoreTokens())
		{
			String token = st.nextToken();
			if(onlyLettersIncluded(token)) {
			   count++;
			}
		}		
		return count;
	}
	
	public boolean onlyLettersIncluded(String token) {
		
		return token.matches("[a-zA-Z]+");
	}
}
