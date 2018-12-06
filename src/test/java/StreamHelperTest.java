import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;

public class StreamHelperTest {

    private static String EXPECTED_DATA = "This is a test";

    @Test
    public void testFileHelperReadFromInputStreamReturnsCorrectString() throws IOException {
        ByteArrayInputStream content = new ByteArrayInputStream(EXPECTED_DATA.getBytes());

        String data = StreamHelper.readFromInputStream(content);

        Assert.assertThat(data, containsString(EXPECTED_DATA));
    }
}
