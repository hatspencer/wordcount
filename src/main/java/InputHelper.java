import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class InputHelper {

    public InputHelper(){

    }


    public String getTextFile(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        File textFile = new File(classLoader.getResource(fileName).getFile());
        try {
            return FileUtils.readFileToString(textFile, "UTF-8");

        } catch (IOException e) {
            System.out.println("Could not load file!");
            e.printStackTrace();
        }
    }

    public String getConsoleText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your text:");

        if(scanner.hasNextLine()) {
            return scanner.nextLine();
        }

        return "";
    }
}
