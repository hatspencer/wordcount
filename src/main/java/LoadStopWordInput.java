import java.io.BufferedReader;
import java.io.IOException;

public interface LoadStopWordInput {

    BufferedReader getStopWordFileByPath(String path) throws IOException;
}
