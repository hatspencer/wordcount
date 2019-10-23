package sk.linhard.wc;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;

public class WordCounter {

	private static final int SEPARATOR = 32;
	private static final int LOWER_A = 97;
	private static final int LOWER_Z = 122;
	private static final int UPPER_A = 65;
	private static final int UPPER_Z = 90;

	private Reader input;

	public WordCounter(Reader input) {
		this.input = input;
	}

	private boolean isLegalChar(int character) {
		return (character >= LOWER_A && character <= LOWER_Z) || (character >= UPPER_A && character <= UPPER_Z);
	}

	public int count() {
		try {
			int count = 0;
			boolean inSeparator = true;
			boolean legalCharSequence = true;
			int c;
			while ((c = input.read()) != -1) {
				if (c == SEPARATOR) {
					if (!inSeparator) {
						if (legalCharSequence) {
							count++;
						}
						inSeparator = true;
					}
				} else {
					if (!isLegalChar(c)) {
						legalCharSequence = false;
					}
					inSeparator = false;
				}
			}
			if (!inSeparator && legalCharSequence) {
				count++;
			}
			return count;
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
