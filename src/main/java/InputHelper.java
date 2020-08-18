

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
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
            throw new FailedInputException("Could not get text from user input!");
        }
    }

    public static String readFile(String fileName) throws FailedInputException {
        ClassLoader classLoader = InputHelper.class.getClassLoader();
        File stopFile = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        try {
            return FileUtils.readFileToString(stopFile, "UTF-8");

        } catch (IOException e) {
            System.err.println("Could not load input file!" + fileName);
            throw new FailedInputException("Could not get text from user input!");
        }
    }

    public static Set<String> setStopWords() throws FailedInputException{
        Set<String> stopWordsSet = new HashSet<String>();
        String data = InputHelper.readFile("stopwords.txt");

        String[] stopWords = data.split("\r\n");
        for(String word: stopWords){
            stopWordsSet.add(word.toLowerCase());
        }

        return stopWordsSet;

    }
}
