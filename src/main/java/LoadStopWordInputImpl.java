import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadStopWordInputImpl implements LoadStopWordInput {

    @Override
    public BufferedReader getStopWordFileByPath(String path) throws IOException {
        File inputFile = new File(path);
        InputStream is = new FileInputStream(inputFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        return reader;
    }
}
