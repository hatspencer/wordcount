import java.util.Scanner;

public class ConsoleInputReader implements WordInputReader {

    private final Scanner scanner;

    public ConsoleInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public ConsoleInputReader() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String processInput() {
        System.out.print("Enter Text: ");
        String text = scanner.nextLine();
        scanner.close();

        return text;
    }
}
