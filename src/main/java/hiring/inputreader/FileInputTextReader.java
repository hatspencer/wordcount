package hiring.inputreader;

import hiring.filereader.FileContentReader;

public class FileInputTextReader implements InputTextReader {

	private String fileName;
	private FileContentReader fileContentReader;

	public FileInputTextReader(String fileName, FileContentReader fileContentReader) {
		this.fileName = fileName;
		this.fileContentReader = fileContentReader;
	}

	@Override
	public String readInputText() {
		return fileContentReader.readFileContent(fileName);
	}
}
