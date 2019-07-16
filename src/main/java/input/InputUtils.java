package input;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputUtils {

    public static List<String> readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        scanner.close();
        return new ArrayList<>(splitToLines(text));
    }

    public static List<String> readFromFile(String fileURI) {
        File file = new File(fileURI);
        return readFile(file);
    }

    public static List<String> readFromResource(String resourceName) {
        ClassLoader classLoader = new InputUtils().getClass().getClassLoader();
        return readFile(new File(classLoader.getResource(resourceName).getFile()));
    }

    private static List<String> readFile(File file) {
        Scanner scanner;
        List<String> lines = new ArrayList<>();
        try {
            scanner = new Scanner(file);
            do {
                lines.addAll(splitToLines(scanner.nextLine()));
            } while (scanner.hasNextLine());
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<String> splitToLines(String toSplit) {
        if (toSplit == null || toSplit.equals("")) {
            return new ArrayList<>();
        }
        return Arrays.asList(toSplit.trim().split("[\\s+,-]"));
    }
}
