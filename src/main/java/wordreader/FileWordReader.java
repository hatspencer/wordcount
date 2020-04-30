package wordreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileWordReader implements WordReader {

    private final String fileName;
    private final List<String> words;

    public FileWordReader(String fileName) {
        this.words = new ArrayList<>();
        this.fileName = fileName;
   }

    @Override
    public Collection<String> readWords() {

        words.clear();

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                words.addAll(Arrays.asList(data.split(" ")));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        return words;
    }

}
