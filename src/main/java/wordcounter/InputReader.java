package wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {

    public String readFromSystemIn(String welcomeMessage) {

        System.out.print(welcomeMessage);
        Scanner inputReader = new Scanner(System.in);
        return inputReader.nextLine();
    }

    public List<String> readFromFile(String filename) throws FileNotFoundException {
        URL url = getClass().getClassLoader().getResource(filename);
        if(url == null){
            throw new FileNotFoundException(filename);
        }
        File file = new File(url.getFile());
        List<String> lines = new ArrayList<>();
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.printf(" %s: file was not found", file);
            e.printStackTrace();
        }

        return lines;
    }
}
