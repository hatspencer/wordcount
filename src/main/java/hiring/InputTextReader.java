package hiring;

import java.util.Scanner;

public class InputTextReader {

	public String readInputText() {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter text: ");

		String inputText = inputScanner.nextLine();

		return inputText;
	}

}
