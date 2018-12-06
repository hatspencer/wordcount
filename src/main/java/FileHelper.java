
import java.io.InputStream;

public final class FileHelper {

    public static InputStream getInputStreamOfResource(String filePath) {
        Class clazz = FileHelper.class;
        return  clazz.getResourceAsStream(filePath);
    }
}
