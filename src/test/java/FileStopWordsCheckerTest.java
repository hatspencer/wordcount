import impl.FileStopWordsChecker;
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

	private FileStopWordsChecker defaultFileStopWordsChecker = new FileStopWordsChecker();
	private FileStopWordsChecker customFileStopWordsChecker;
	private static Path customStopWordsPath;

	@ParameterizedTest
	@MethodSource("defaultStopWordsProvider")
	void testDefaultStopWords(boolean expectedResult, String word) {
		assertEquals(expectedResult, defaultFileStopWordsChecker.isStopWord(word));
	}

	static Stream<Arguments> defaultStopWordsProvider() {
		return Stream.of(
				arguments(true, "one"),
				arguments(true, "two"),
				arguments(true, "three"),
				arguments(false, "not_a_stop_word")
		);
	}

	@ParameterizedTest
	@MethodSource("customStopWordsProvider")
	void testCustomStopWords(boolean expectedResult, String word) throws IOException {
		assertEquals(expectedResult, getCustomFileStopWordsChecker().isStopWord(word));
	}

	static Stream<Arguments> customStopWordsProvider() {
		return Stream.of(
				arguments(true, "four"),
				arguments(false, "not_a_stop_word")
		);
	}

	private FileStopWordsChecker getCustomFileStopWordsChecker() throws IOException {
		if (customFileStopWordsChecker == null) {
			customStopWordsPath = Files.createTempFile("customstopwords", ".txt");
			Files.write(customStopWordsPath, Collections.singletonList("four"));
			customFileStopWordsChecker = new FileStopWordsChecker(customStopWordsPath.toAbsolutePath().toString());
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