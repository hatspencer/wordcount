package hiring.inputreader;

import hiring.filereader.FileContentReader;
import hiring.filereader.TextFileContentReader;

public class FileInputTextReader implements InputTextReader {

	private String fileName;

	public FileInputTextReader(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String readInputText() {
		FileContentReader textFileContentReader = new TextFileContentReader();
		return textFileContentReader.readFileContent(this.fileName);
	}

}
