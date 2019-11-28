import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
public class CommandLineInputReader implements InputReader {

    @Override
    public String readInput() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");

        try {
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            throw new IOException("Invalid input");
        }
    }
}
