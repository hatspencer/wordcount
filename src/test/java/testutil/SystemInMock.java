package testutil;

import java.io.ByteArrayInputStream;

public class SystemInMock {

    public static void mockSystemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

}