package api;

public interface WordCounter {

	int count(String input, WordsProvider wordsProvider, WordFilter wordFilter);
}

