import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class WordCount {

    HashMap<String, String> stopWordsMap;

    public WordCount(){
        stopWordsMap = new HashMap<>();
    }

    public HashMap<String, String> getStopWordsMap() {
        return stopWordsMap;
    }

    public void setStopWordsMap(HashMap<String, String> stopWordsMap) {
        this.stopWordsMap = stopWordsMap;
    }

    public int countWords(String text){
        setStopWords();
        int wordCounter = 0;
        String[] words = text.split(" ");
        for(int i = 0; i<=words.length-1; i++){
            if(words[i].matches("^[a-zA-Z]+$") && !isStopWord(words[i])) {
                System.out.println(words[i]);
                wordCounter += 1;
            }

        }
        return wordCounter;
    }

    private void setStopWords() {
        ClassLoader classLoader = getClass().getClassLoader();
        File stopFile = new File(classLoader.getResource("stopWords.txt").getFile());
        try {
            String data = FileUtils.readFileToString(stopFile, "UTF-8");

            String[] stopWords = data.split("\r\n");
            for(String word: stopWords){
                stopWordsMap.putIfAbsent(word.toLowerCase(), word.toLowerCase());
            }


        } catch (IOException e) {
            System.out.println("Could not load file!");
            e.printStackTrace();
        }
    }
    private boolean isStopWord(String word) {
        return this.getStopWordsMap().containsKey(word.toLowerCase());
    }

    private String getTextFile(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        File textFile = new File(classLoader.getResource(fileName).getFile());
        try {
            return FileUtils.readFileToString(textFile, "UTF-8");

        } catch (IOException e) {
            System.out.println("Could not load file!");
            e.printStackTrace();
        }
    }

    private String getConsoleText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your text:");

        if(scanner.hasNextLine()) {
            return scanner.nextLine();
        }

        return "";
    }

    public static void main(String[] args){

        String inputText;
        int counter;

        WordCount wordCount = new WordCount();
        wordCount.setStopWords();


        if(args.length>0) {
            String fileName = args[0];
            inputText = wordCount.getTextFile(fileName);
        }
        else {
            inputText = wordCount.getConsoleText();
        }

        counter = wordCount.countWords(inputText);

        System.out.println("this is your word count: " + counter);
    }

}
