package wordcount.dto;

public class WordCountResult {

	private final long wordCount;
	
	private final long wordCountUnique;

	public WordCountResult(long wordCount, long wordCountUnique) {
		this.wordCount = wordCount;
		this.wordCountUnique = wordCountUnique;
	}
	
	public long getWordCount() {
		return wordCount;
	}
	
	public long getWordCountUnique() {
		return wordCountUnique;
	}
	
}
