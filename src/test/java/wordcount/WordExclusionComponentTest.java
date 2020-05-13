package wordcount;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import wordcount.service.WordExclusionComponent;

public class WordExclusionComponentTest {

	@Test
	public void testWordExclusion() {
		String[] data = new String[] {"a", "b", "c", "d", "e"};
		boolean[] results = new boolean[] {true, true, true, false, false};
		String[] testData = new String[] {"a", "b", "c"};
		WordExclusionComponent wordExclusionComponent = new WordExclusionComponent(Arrays.asList(testData));
		for (int i = 0; i < data.length; i++) {
			String input = data[i];
			boolean expectedResult = results[i];
			boolean actualResult = wordExclusionComponent.isWordExcluded(input);
			Assert.assertEquals(expectedResult, actualResult);
		}

	}
	
}
