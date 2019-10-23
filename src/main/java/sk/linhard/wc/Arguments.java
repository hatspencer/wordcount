package sk.linhard.wc;

import java.io.File;
import java.util.Optional;

public class Arguments {

	private Optional<File> inputFile = Optional.empty();
	private boolean printIndex = false;
	private Optional<File> dictionaryFile = Optional.empty();

	public Optional<File> inputFile() {
		return inputFile;
	}

	public boolean printIndex() {
		return printIndex;
	}

	public Optional<File> dictionaryFile() {
		return dictionaryFile;
	}

	private static File getFileFromOpt(String prefix, String opt) {
		return new File(opt.substring(prefix.length()));
	}

	public static Arguments parse(String... args) {
		Arguments parsedArgs = new Arguments();

		for (String arg : args) {
			if ("-index".equals(arg)) {
				parsedArgs.printIndex = true;
			} else if (arg.startsWith("-dictionary=")) {
				parsedArgs.dictionaryFile = Optional.of(getFileFromOpt("-dictionary=", arg));
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
