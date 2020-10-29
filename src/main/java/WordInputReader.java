import java.util.Scanner;

public class WordInputReader {

    private Scanner scanner;

    public WordInputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readInput() {
        String text = scanner.nextLine();
        return "";
    }
}
