package userinput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileInputReader implements UserInputReader {

    private String filename;

    public FileInputReader(String filename){
        this.filename = filename;
    }

    @Override
    public String readUserInput(){
        try {
            return String.join(" ", Files.readAllLines(Paths.get(filename)));
        } catch (IOException e) {
            System.out.println("Could not read input file.");
            return "";
        }
    }
}
