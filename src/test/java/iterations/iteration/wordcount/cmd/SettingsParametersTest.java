package iterations.iteration.wordcount.cmd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SettingsParametersTest {

	@Test
	public void test() {
		SettingsParameters params = SettingsParameters.parse(new String[]{""});
		assertFalse(params.isIndex());
		
		params = SettingsParameters.parse(new String[]{"-index"});
		assertTrue(params.isIndex());
		assertEquals(params.getInputFileName(), "");
		
		params = SettingsParameters.parse(new String[]{"-index", "stopwords.txt"});
		assertEquals(params.getInputFileName(), "stopwords.txt");
		assertTrue(params.isIndex());
	}
	
}
