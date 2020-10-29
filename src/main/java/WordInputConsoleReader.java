import java.util.Scanner;

public class WordInputConsoleReader implements WordInputReader {

    private final Scanner scanner;

    public WordInputConsoleReader() {
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
