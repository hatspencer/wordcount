
import java.util.HashSet;
import java.util.Set;

public class WordCount {

    Set<String> stopWordsMap;


    Set<String> uniqueWords;

    public WordCount(Set stopWords){
        setStopWordsSet(stopWords);
    }

    public Set<String> getStopWordsMap() {
        return stopWordsMap;
    }

    public void setStopWordsMap(Set<String> stopWordsMap) {
        this.stopWordsMap = stopWordsMap;
    }

    public Set<String> getUniqueWords() {
        return uniqueWords;
    }

    public void setUniqueWords(Set<String> uniqueWords) {
        this.uniqueWords = uniqueWords;
    }

    public Set<String> getStopWordsSet() {
        return stopWordsMap;
    }

    public void setStopWordsSet(Set<String> stopWordsMap) {
        this.stopWordsMap = stopWordsMap;
    }

    public int countWords(String text){
        int wordCounter = 0;
        Set<String> uniqueWords = new HashSet<>();
        String[] words = text.split("\\W+");
        for(int i = 0; i<=words.length-1; i++){
            if(words[i].matches("^[a-zA-Z]+$") && !isStopWord(words[i])) {
                wordCounter += 1;
                uniqueWords.add(words[i]);
            }

        }
        setUniqueWords(uniqueWords);
        return wordCounter;
    }

    private boolean isStopWord(String word) {
        return this.getStopWordsSet().contains(word.toLowerCase());
    }



    public static void main(String[] args){

        String inputText;
        int counter;

        try {
            WordCount wordCount = new WordCount(InputHelper.setStopWords());

            if(args.length>0) {
                String fileName = args[0];
                inputText = InputHelper.readInputTextFile(fileName);
            }
            else{
                inputText = InputHelper.getConsoleText();
            }

            counter = wordCount.countWords(inputText);

            System.out.println("Number of words: " + counter + ", unique: " + wordCount.getUniqueWords().size());

        } catch (FailedInputException e) {
            e.printStackTrace();
        }


    }

}
