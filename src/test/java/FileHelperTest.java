import org.junit.Test;

import java.io.InputStream;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileHelperTest {

    @Test
    public void testIfFileHelperGetInputStreamWihtValidResource() {

        InputStream inputStream = FileHelper.getInputStreamOfResource("/file_helper_test.txt");

        assertThat(inputStream, instanceOf(InputStream.class));
    }
}