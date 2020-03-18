import java.util.Scanner;

public class CounterApp {

	public static void main(String[] args) {
		
		System.out.println("Enter text: ");		
		Scanner scanner = new Scanner(System.in);			
		String message = scanner.nextLine();
		
		Counter counter = new WordCounter(message);
		int count =  counter.wordsCount();
		
		System.out.println("Number of words: " + count);
	}

}
