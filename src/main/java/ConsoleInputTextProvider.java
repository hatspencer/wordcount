import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputTextProvider implements InputTextProvider {

    @Override
    public String getInput() {
        System.out.print("Enter text: ");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = reader.readLine();

            if (line == null || line.isEmpty()) {
                System.exit(0);
                reader.close();
            }
            return line;
        } catch (IOException e) {
            System.err.println("Error during reading input from command line " + e.getMessage());
            return "";
        }
    }
}
