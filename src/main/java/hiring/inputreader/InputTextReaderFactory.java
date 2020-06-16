package hiring.inputreader;

import hiring.filereader.FileContentReader;
import hiring.filereader.TextFileContentReader;
import hiring.outputprinter.OutputPrinter;
import hiring.outputprinter.SystemOutputPrinter;

public class InputTextReaderFactory {

	public static InputTextReader createInputTextReader(String inputFileName) {
		if (inputFileName == null) {
			OutputPrinter outputPrinter = new SystemOutputPrinter();
			return new SystemInputTextReader(outputPrinter);
		} else {
			FileContentReader textFileContentReader = new TextFileContentReader();
			return new FileInputTextReader(inputFileName, textFileContentReader);
		}
	}
}
