package sk.linhard.wc;

import java.io.File;
import java.util.Optional;

public class Arguments {

	private Optional<File> inputFile = Optional.empty();
	private boolean printIndex = false;

	public Optional<File> inputFile() {
		return inputFile;
	}

	public boolean printIndex() {
		return printIndex;
	}

	public static Arguments parse(String... args) {
		Arguments parsedArgs = new Arguments();

		for (String arg : args) {
			if ("-index".equals(arg)) {
				parsedArgs.printIndex = true;
			} else {
				if (parsedArgs.inputFile.isPresent()) {
					throw new IllegalArgumentException("can't have two input files");
				} else {
					parsedArgs.inputFile = Optional.of(new File(arg));
				}
			}
		}

		return parsedArgs;
	}

}
