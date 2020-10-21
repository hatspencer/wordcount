import org.junit.Test;

import java.io.ByteArrayInputStream;

public class MainTest {

    @Test
    public void testWithArgument() {
        Main.main(new String[]{"FooFile.txt"});
    }

    @Test
    public void testWithEmptyArguments() {
        final ByteArrayInputStream userMockInput = new ByteArrayInputStream("Some Mock String".getBytes());
        System.setIn(userMockInput);
        Main.main(new String[]{});
    }

    @Test
    public void testMainWithFilename() {
        final ByteArrayInputStream userMockInput = new ByteArrayInputStream("Some Mock String".getBytes());
        System.setIn(userMockInput);
        Main.main(new String[]{"FooFile.txt"});
    }

    @Test
    public void testMainWithIndex() {
        final ByteArrayInputStream userMockInput = new ByteArrayInputStream("Some Mock String".getBytes());
        System.setIn(userMockInput);
        Main.main(new String[]{"-index"});
    }

    @Test
    public void testMainWithIndexAndFilename() {
        final ByteArrayInputStream userMockInput = new ByteArrayInputStream("Some Mock String".getBytes());
        System.setIn(userMockInput);
        Main.main(new String[]{"-index", "FooFile.txt"});
    }

    @Test(expected = Exception.class)
    public void testMainWithInvalidFilename() {
        final ByteArrayInputStream userMockInput = new ByteArrayInputStream("Some Mock String".getBytes());
        System.setIn(userMockInput);
        Main.main(new String[]{"SomeInvalid"});
    }
}
