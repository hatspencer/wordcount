import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileStopWordReader implements StopWordReader {

    private static final String STOP_WORDS_FILENAME = "src/main/resources/stopwords.txt";

    private final Set<String> stopWords;

    public FileStopWordReader() {
        stopWords = new HashSet<>();
   }

    @Override
    public Set<String> readStopWords() {

        stopWords.clear();

        try {
            File myObj = new File(STOP_WORDS_FILENAME);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stopWords.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }


        return stopWords;
    }

}
