package api;

public interface WordCounter {

	int count(String input, StopWordChecker stopWordChecker);

	int count(String input);
}

