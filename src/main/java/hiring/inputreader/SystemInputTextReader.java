package hiring.inputreader;

import hiring.outputprinter.OutputPrinter;

import java.util.Scanner;

public class SystemInputTextReader implements InputTextReader {

	private OutputPrinter outputPrinter;

	public SystemInputTextReader(OutputPrinter outputPrinter) {
		this.outputPrinter = outputPrinter;
	}

	@Override
	public String readInputText() {
		outputPrinter.print("Enter text: ");

		Scanner inputScanner = new Scanner(System.in);
		String inputText = inputScanner.nextLine();

		return inputText;
	}

}
