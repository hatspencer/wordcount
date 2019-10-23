package sk.linhard.wc;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class ArgumentsTest {

	@Test
	public void testBasicArguments() {
		Arguments args = Arguments.parse("-index", "blah.txt");
		Assert.assertEquals(new File("blah.txt"), args.inputFile().get());
		Assert.assertEquals(true, args.printIndex());
	}

	@Test
	public void testEmptyArguments() {
		Arguments args = Arguments.parse();
		Assert.assertEquals(false, args.inputFile().isPresent());
		Assert.assertEquals(false, args.printIndex());
	}

}
