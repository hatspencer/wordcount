package hiring;

class AppArguments {
	private String inputFileName;

	public AppArguments(String[] args) {
		if (args.length == 0) {
			// no argument is also allowed
		} else if (args.length == 1) {
			inputFileName = args[0];
		} else {
			throw new IllegalArgumentException("Too many arguments\nUsage: appName <INPUT_FILE_PATH>");
		}
	}

	public String getInputFileName() {
		return inputFileName;
	}

}