import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WordCount {

    public WordCount(){

    }

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your text:");
        String inputText = null;
        try {
            inputText = br.readLine();
        } catch (IOException e) {
            System.out.println("Could not parse text!");
        }

        System.out.println("Text entered:" + inputText);
        input.close();

    }
}
