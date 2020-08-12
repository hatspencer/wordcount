package wordcount;

public class WordCount {
    
    public static void main(String[] args) {
        
        String input = UserInput.getInputFromUser();
        
        String[] splittedInput = Splitter.split(input);
        
//        System.out.println("debug "+input);
        System.out.println("Number of words: " + WordCounter.getWordsCount(splittedInput));

    }
     
}
