import java.util.Scanner;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
public class InputTextReader {

    public String readInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");

        return scanner.nextLine();
    }
}
