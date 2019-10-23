package sk.linhard.wc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.Optional;

public class Main {

	private static final Charset UTF_8 = Charset.forName("UTF-8");
	private static final String STOPWORDS_FILE_NAME = "stopwords.txt";

	public static void main(String[] args) {
		try {
			Arguments parsedArgs = Arguments.parse(args);
			try (Reader inputReader = createInputReader(parsedArgs.inputFile())) {
				WordCountApp app = new WordCountApp(inputReader, UTF_8, Optional.of(new File(STOPWORDS_FILE_NAME)));
				System.out.print(parsedArgs.printIndex() ? app.computeOutputWithIndex() : app.computeOutput());
			}
		} catch (Throwable e) {
			System.err.println("ERROR: " + e.getMessage());
		}
	}

	private static Reader createInputReader(Optional<File> inputFile) throws IOException {
		if (!inputFile.isPresent()) {
			System.out.print("Enter text: ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, UTF_8));
			return new StringReader(reader.readLine());
		} else {
			return new InputStreamReader(new FileInputStream(inputFile.get()), UTF_8);
		}
	}

}
