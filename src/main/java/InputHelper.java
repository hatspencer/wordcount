
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class InputHelper {

    public InputHelper(){

    }


    public static String getConsoleText() throws FailedInputException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your text:");

        if(scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        else{
            System.err.println("Could not load input text!");
            throw new FailedInputException("Could not load input from console!");
        }
    }

    public static String readFile(InputStreamReader inputStreamReader) throws FailedInputException {

        StringBuilder sb = new StringBuilder();

        try (BufferedReader br =  new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();

        } catch (IOException e) {
            System.err.println("Could not load input file!");
            e.printStackTrace();
            throw new FailedInputException(e.getMessage());
        }

    }

    public static Set<String> setStopWords() throws FailedInputException{
        Set<String> stopWordsSet = new HashSet<String>();
        InputStreamReader inputStreamReader = new InputStreamReader(
                InputHelper.class.getClass().getResourceAsStream("/" + "stopwords.txt"));
        String data = InputHelper.readFile(inputStreamReader);

        String[] stopWords = data.split("\n");
        for(String word: stopWords){
            stopWordsSet.add(word.toLowerCase());
        }

        return stopWordsSet;

    }
}
