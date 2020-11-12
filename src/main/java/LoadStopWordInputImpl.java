import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadStopWordInputImpl implements LoadStopWordInput {

    @Override
    public BufferedReader getStopWordFileByPath(String path) throws IOException {
        BufferedReader reader =
                Files.newBufferedReader(Paths.get(path));
        return reader;
    }
}
