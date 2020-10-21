import org.junit.Test;

import java.io.ByteArrayInputStream;

public class MainTest {

    @Test
    public void testWithArgument() {
        Main.main(new String[]{"FooFile.txt"});
    }

    @Test
    public void testWithEmptyArguments() {
        final ByteArrayInputStream userMockInput = new ByteArrayInputStream("".getBytes());
        System.setIn(userMockInput);
        Main.main(new String[]{});
    }
}
