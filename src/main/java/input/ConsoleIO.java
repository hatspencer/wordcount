package input;

import java.util.Scanner;

public class ConsoleIO {
	
	public static String getUserInput() {
		Scanner in = new Scanner(System.in); 
		System.out.println("Enter text:");
		return in.nextLine();
	}
	
	public static void printResult(int wordCount) {
		System.out.println("Number of words: "+ wordCount);
	}

}
