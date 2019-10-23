package sk.linhard.wc;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Reads the text input given in the constructor char-by-char till the end and
 * counts the words.
 */
public class WordCounter {

	private static final int SEPARATOR = 32;
	private static final int LOWER_A = 97;
	private static final int LOWER_Z = 122;
	private static final int UPPER_A = 65;
	private static final int UPPER_Z = 90;

	private Set<String> stopwords;
	private Reader input;
	private StringBuilder lastWord;

	/**
	 * 
	 * @param input     The input reader. Won't be closed by running
	 *                  {@link #count()} method.
	 * @param stopwords Collection of stopwords, if they are repeated, duplicates
	 *                  will be ignored.
	 */
	public WordCounter(Reader input, Collection<String> stopwords) {
		this.stopwords = new HashSet<String>(stopwords);
		this.input = input;
		this.lastWord = null;
	}

	private boolean isLegalChar(int character) {
		return (character >= LOWER_A && character <= LOWER_Z) || (character >= UPPER_A && character <= UPPER_Z);
	}

	private char toChar(int codePoint) {
		if (!Character.isValidCodePoint(codePoint)) {
			throw new IllegalArgumentException("Invalid codepoint");
		}
		return (char) codePoint;
	}

	private void appendToLastWord(int character) {
		if (this.lastWord == null) {
			this.lastWord = new StringBuilder();
		}
		lastWord.append(toChar(character));
	}

	private boolean isLastWordStopWord() {
		return lastWord == null ? false : stopwords.contains(lastWord.toString());
	}

	private void discardLastWord() {
		this.lastWord = null;
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
						if (legalCharSequence && !isLastWordStopWord()) {
							count++;
						}
						inSeparator = true;
						legalCharSequence = true;
						discardLastWord();
					}
				} else {
					if (!isLegalChar(c)) {
						legalCharSequence = false;
					}
					inSeparator = false;
					appendToLastWord(c);
				}
			}
			if (!inSeparator && legalCharSequence && !isLastWordStopWord()) {
				count++;
			}
			return count;
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
