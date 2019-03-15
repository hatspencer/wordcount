package impl;

import impl.StopWordsFilter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FileStopWordsCheckerTest {

	private StopWordsFilter defaultFileStopWordsChecker = new StopWordsFilter();
	private StopWordsFilter customFileStopWordsChecker;
	private static Path customStopWordsPath;

	@ParameterizedTest
	@MethodSource("defaultStopWordsProvider")
	void testDefaultStopWords(boolean expectedResult, String word) {
		assertEquals(expectedResult, defaultFileStopWordsChecker.accept(word));
	}

	static Stream<Arguments> defaultStopWordsProvider() {
		return Stream.of(
				arguments(false, "one"),
				arguments(false, "two"),
				arguments(false, "three"),
				arguments(true, "not_a_stop_word")
		);
	}

	@ParameterizedTest
	@MethodSource("customStopWordsProvider")
	void testCustomStopWords(boolean expectedResult, String word) throws IOException {
		assertEquals(expectedResult, getCustomFileStopWordsChecker().accept(word));
	}

	static Stream<Arguments> customStopWordsProvider() {
		return Stream.of(
				arguments(false, "four"),
				arguments(true, "not_a_stop_word")
		);
	}

	private StopWordsFilter getCustomFileStopWordsChecker() throws IOException {
		if (customFileStopWordsChecker == null) {
			customStopWordsPath = Files.createTempFile("customstopwords", ".txt");
			Files.write(customStopWordsPath, Collections.singletonList("four"));
			customFileStopWordsChecker = new StopWordsFilter(customStopWordsPath.toAbsolutePath().toString());
		}

		return customFileStopWordsChecker;
	}

	@AfterAll
	static void deleteCustomFileStopChecker() throws IOException {
		if (customStopWordsPath != null) {
			Files.delete(customStopWordsPath);
		}
	}
}