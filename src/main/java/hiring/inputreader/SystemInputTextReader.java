package hiring.inputreader;

import java.util.Scanner;

public class SystemInputTextReader implements InputTextReader {

	@Override
	public String readInputText() {
		Scanner inputScanner = new Scanner(System.in);
		String inputText = inputScanner.nextLine();

		return inputText;
	}

}
