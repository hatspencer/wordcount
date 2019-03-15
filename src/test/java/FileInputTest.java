import impl.FileInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FileInputTest {

	private static final String ONE_LINE_OF_TEXT = "one line of text";
	private static final String TWO_LINES_OF_TEXT = "line one\nline two";

	private static final String NONEXISTENT_FILE_NAME = "file_that_does_not_exist.txt";

	private Path temporaryFilePath;

	@Test
	void getInputReturnsOneLifeOfText() {
		temporaryFilePath = createTemporaryFile(ONE_LINE_OF_TEXT);
		FileInput fileInput = new FileInput(temporaryFilePath.toString());

		String input = fileInput.getInput();

		Assertions.assertEquals(ONE_LINE_OF_TEXT + '\n', input);
	}

	@Test
	void getInputReturnsTwoLinesOfText() {
		temporaryFilePath = createTemporaryFile(TWO_LINES_OF_TEXT);
		FileInput fileInput = new FileInput(temporaryFilePath.toString());

		String input = fileInput.getInput();

		Assertions.assertEquals(TWO_LINES_OF_TEXT + '\n', input);
	}

	@ParameterizedTest
	@MethodSource("emptyFileNames")
	void createFileInputWithEmptyFilenameThrowsIllegalArgumentException(String fileName) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new FileInput(fileName));
	}

	static Stream<Arguments> emptyFileNames() {
		return Stream.of(
				arguments(""),
				arguments(" "),
				arguments((Object) null)
		);
	}

	@Test
	void getInputForNonexistentFileNameThrowsRuntimeException() {
		FileInput fileInput = new FileInput(NONEXISTENT_FILE_NAME);

		assertThrows(RuntimeException.class, fileInput::getInput);
	}

	@AfterEach
	void deleteTemporaryFile() throws IOException {
		if (temporaryFilePath != null) {
			Files.delete(temporaryFilePath);
		}
	}

	private Path createTemporaryFile(String content) {
		Path path = null;

		try {
			path = Files.createTempFile("input", ".txt");
			Files.write(path, Collections.singletonList(content));
		} catch (IOException e) {
			System.err.println("Failed to create temporary file for testing.");

			if (path != null) {
				try {
					Files.delete(path);
				} catch (IOException e1) {
					System.err.println("Failed to delete temporary file '" + path.toString() + "'.");
				}
			}

			throw new RuntimeException(e);
		}

		return path;
	}
}
