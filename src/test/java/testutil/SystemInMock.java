package testutil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class SystemInMock {

    public static void mockSystemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void assertSystemOut(ByteArrayOutputStream outputStreamCaptor, String expectedOutput) {
        String output = outputStreamCaptor.toString().trim();
        assertEquals(expectedOutput, output);
    }

}