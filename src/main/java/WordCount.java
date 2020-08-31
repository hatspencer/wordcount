import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordCount {

    public static void main(String[] args) {

        // input reader
        // store input to string
        // analyse text
            // while loop
            // regex
        // count words
        //Enter data using BufferReader
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine

        try {
            String name = reader.readLine();
            System.out.println(name);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
