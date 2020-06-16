package hiring.wordcounter;

public class WordCounterResult {
	private int numberOfWords;
	private int numberOfUniqueWords;
	private double averageWordLength;

	public int getNumberOfWords() {
		return numberOfWords;
	}

	public void setNumberOfWords(int numberOfWords) {
		this.numberOfWords = numberOfWords;
	}

	public int getNumberOfUniqueWords() {
		return numberOfUniqueWords;
	}

	public void setNumberOfUniqueWords(int numberOfUniqueWords) {
		this.numberOfUniqueWords = numberOfUniqueWords;
	}

	public double getAverageWordLength() {
		return averageWordLength;
	}

	public void setAverageWordLength(double averageWordLength) {
		this.averageWordLength = averageWordLength;
	}
}
