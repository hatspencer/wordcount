import java.util.Scanner;

public class WordCount {

    public WordCount(){

    }

    public int countWords(String text){
        int wordCounter = 0;
        String[] words = text.split(" ");
        for(int i = 0; i<=words.length-1; i++){
            if(words[i].matches("^[a-zA-Z]+$")) {
                System.out.println(words[i]);
                wordCounter += 1;
            }

        }
        return wordCounter;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your text:");

        if(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int counter = new WordCount().countWords(line);
            System.out.println("this is your word count: " + counter);


        }




    }
}
