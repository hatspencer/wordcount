package hiring;

import hiring.resourcereader.FileContentReader;
import hiring.wordcounter.StopWordsLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class StopWordsLoaderTest {

	@Test
	public void GIVEN_two_stop_words_from_file_WHEN_load_stop_words_THEN_correct_count() {
		// given
		String stopWordsFileContent = "word1\nword2";
		int expectedSstopWordsCount = 2;
		FileContentReader mockFileContentReader = createMockFileContentReader(stopWordsFileContent);
		StopWordsLoader stopWordsLoader = new StopWordsLoader(mockFileContentReader);

		// when
		Set<String> stopWords = stopWordsLoader.loadStopWords("ignored_filename");

		// then
		assertEquals(expectedSstopWordsCount, stopWords.size());
	}

	private FileContentReader createMockFileContentReader(String contentToReturn) {
		return new FileContentReader() {
			@Override
			public String readFileContent(String fileName) {
				return contentToReturn;
			}
		};
	}


}