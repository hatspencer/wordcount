package wordcount;

import org.junit.Assert;
import org.junit.Test;

public class UserInputReaderFactoryTest {

	@Test
	public void testTooManyArguments() {
		Assert.assertThrows(IllegalArgumentException.class, 
				() -> UserInputReaderFactory.createUserInputReaderFrom(new String[] {"arg1", "arg2"}));
	}
	
	@Test
	public void testSingleArgument() {
		UserInputReader userInputReader = UserInputReaderFactory.createUserInputReaderFrom(new String[] {"arg1"});
		Assert.assertEquals(FileUserInputReader.class, userInputReader.getClass());
	}
	
	@Test
	public void testNoArgument() {
		UserInputReader userInputReader = UserInputReaderFactory.createUserInputReaderFrom(new String[] {});
		Assert.assertEquals(ConsoleUserInputReader.class, userInputReader.getClass());
	}
}
