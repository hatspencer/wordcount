package hiring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class AppArgumentsTest {

	AppArguments appArguments;

	@Test
	public void GIVEN_zero_arguments_WHEN_parse_arguments_THEN_null_attributes() {
		// given
		String[] args = {};

		// when
		appArguments = new AppArguments(args);

		// then
		assertNull(appArguments.getInputFileName());
	}

	@Test
	public void GIVEN_one_argument_WHEN_parse_arguments_THEN_attribute_filled() {
		// given
		String[] args = {"filename"};

		// when
		appArguments = new AppArguments(args);

		// then
		assertEquals("filename", appArguments.getInputFileName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void GIVEN_two_arguments_WHEN_parse_arguments_THEN_exception_expeced() {
		// given
		String[] args = {"first", "second"};

		// when
		appArguments = new AppArguments(args);

		// then exception
	}

}