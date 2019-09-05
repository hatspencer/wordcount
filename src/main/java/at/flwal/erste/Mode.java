package at.flwal.erste;

public enum Mode {
	CLI, FILE;

	public static Mode fromArgs(String[] args) {

		if (args.length == 0) {
			return Mode.CLI;
		}

		if (args.length == 1) {
			return Mode.FILE;
		}

		throw new IllegalArgumentException("Expected 0 or 1 arguments (inputfile name), but got: " + args.length);
	}
}
