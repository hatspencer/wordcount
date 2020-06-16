package hiring.inputreader;

public class InputTextReaderFactory {

	public static InputTextReader createInputTextReader(String inputFileName) {
		if (inputFileName == null) {
			return new SystemInputTextReader();
		} else {
			return new FileInputTextReader(inputFileName);
		}
	}
}
