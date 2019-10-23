package sk.linhard.wc;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;

public class WordCounter {

	private static final int SEPARATOR = 32;

	private Reader input;

	public WordCounter(Reader input) {
		this.input = input;
	}

	public int count() {
		try {
			int count = 0;
			boolean separator = true;
			int c;
			while ((c = input.read()) != -1) {
				if (c == SEPARATOR) {
					if (!separator) {
						count++;
					}
					separator = true;
				} else {
					separator = false;
				}
			}
			return count;
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
