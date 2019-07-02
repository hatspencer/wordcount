package wordcount;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;

public class WordCounter {

	private static final String WHITE_SPACE_REGEX = "\\s+";
	private static final String ONLY_LETTERS_REGEX = "[a-zA-Z]+";

	private final Predicate<String> wordsFilter;

	public WordCounter(Predicate<String> wordsFilter) {
		this.wordsFilter = wordsFilter;
	}

	public long countWordsOf(Collection<String> text) {
		return text.stream()
				.filter(Objects::nonNull)
				.mapToLong(this::countWordsOf)
				.sum();
	}

	public long countWordsOf(String text) {
		String[] split = text.split(WHITE_SPACE_REGEX);

		return Arrays.stream(split)
				.filter(each -> each.matches(ONLY_LETTERS_REGEX))
				.filter(wordsFilter)
				.count();
	}
}
