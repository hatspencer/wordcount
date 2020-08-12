package wordcount;

public class WordCount {
    
    public static void main(String[] args) {
        wordCount();
    }

    public static void wordCount() {
        String input = UserInput.getInputFromUser();
        String[] splittedInput = Splitter.split(input);
        int numberOfWords = WordCounter.getWordsCount(splittedInput);
        System.out.println("Number of words: " + numberOfWords);
    }
     
}
