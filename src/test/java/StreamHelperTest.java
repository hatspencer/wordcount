import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.containsString;

public class StreamHelperTest {

    @Test
    public void testFileHelperReadFromInputStreamReturnsCorrectString() throws IOException {
        String expectedData = "This is a test";

        Class clazz = StreamHelperTest.class;
        InputStream inputStream = clazz.getResourceAsStream("/file_helper_test.txt");
        String data = StreamHelper.readFromInputStream(inputStream);

        Assert.assertThat(data, containsString(expectedData));
    }
}
