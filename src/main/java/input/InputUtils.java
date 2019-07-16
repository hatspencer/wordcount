package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        return new ArrayList<String>(Arrays.asList(text.trim().split("\\s+")));
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
        BufferedReader reader;
        List<String> lines = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
