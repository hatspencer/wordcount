import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordInputReader {

    File inputFile;
    Scanner scanner;

    public WordInputReader(File inputFile, Scanner scanner) {
        this.inputFile = inputFile;
        this.scanner = scanner;
    }

    public String processInput() throws IOException {
        String text;
        if (!inputFile.exists()) {
            System.out.print("Enter Text: ");
            text = scanner.nextLine();
        } else {
            text = Files.lines(inputFile.toPath()).collect(Collectors.joining());
        }
        return text;
    }
}
