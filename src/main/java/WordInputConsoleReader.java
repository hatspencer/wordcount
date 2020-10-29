import java.util.Scanner;

public class WordInputConsoleReader implements WordInputReader {

    private final Scanner scanner;

    private final WordOutputPrinter wordOutputPrinter;

    public WordInputConsoleReader() {
        scanner = new Scanner(System.in);
        wordOutputPrinter = new WordOutputPrinter();
    }

    @Override
    public String processInput() {

        wordOutputPrinter.printEnterText();
        String text = scanner.nextLine();
        scanner.close();

        return text;
    }
}
