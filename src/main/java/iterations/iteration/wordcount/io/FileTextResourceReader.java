package iterations.iteration.wordcount.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class FileTextResourceReader implements ITextResourceReader {
	
	private final File inputfile;
	
	public FileTextResourceReader(String inputName) {
		this.inputfile = new File(inputName);
	}

	@Override
	public String readContent() {
		List<String> input = readLines();
		if (input == null || input.isEmpty())
			return null;
		return String.join(" ", input);
	}

	@Override
	public List<String> readLines() {
		if (inputfile.exists()) {
			LinkedList<String> lines = new LinkedList<String>();
			FileInputStream inputFileStream = null;
			try {
				inputFileStream = new FileInputStream(inputfile);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputFileStream));
				String line;
				while((line = reader.readLine()) != null) {
					lines.add(line);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				if (inputFileStream != null) {
					try {
						inputFileStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return lines;
		}
		return null;
	}

}
