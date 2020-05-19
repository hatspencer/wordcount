import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputTextProvider implements InputTextProvider {

    @Override
    public String getInput() {
        System.out.print("Enter text: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Error during reading input from command line " + e.getMessage());
            throw new WordCountException("IO exception during reading file", e);
        }
    }
}
