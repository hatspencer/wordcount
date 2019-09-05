package at.flwal.erste;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ModeTest {

	@Test
	public void detectModeWithNoArgsShouldReturnCLIMode() {
		Mode mode = Mode.fromArgs(new String[0]);
		assertThat(mode, is(Mode.CLI));
	}

	@Test
	public void detectModeWithOneArgShouldReturnFileMode() {
		Mode mode = Mode.fromArgs(new String[]{"mytext.txt"});
		assertThat(mode, is(Mode.FILE));
	}

	@SuppressWarnings("ResultOfMethodCallIgnored")
	@Test(expected = IllegalArgumentException.class)
	public void detectModeWithTooManyArgumentsShouldFail() {
		Mode.fromArgs(new String[]{"mytext.txt", "bla"});
	}

}
