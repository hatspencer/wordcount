package api;

import java.util.Collection;

public interface WordsProvider {

	Collection<String> getWords(String input);
}