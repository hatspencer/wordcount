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

	private static final int[] SEPARATORS = { (int) ' ', (int) '\n', (int) '\r', (int) '.' };
	private static final int LOWER_A = (int) 'a';
	private static final int LOWER_Z = (int) 'z';
	private static final int UPPER_A = (int) 'A';
	private static final int UPPER_Z = (int) 'Z';
	private static final int DASH = (int) '-';
	private static final int NOT_KNOWN = -1;

	private int count;
	private Set<String> words;
	private Set<String> stopwords;
	private Reader input;
	private boolean lastWordLegal;
	private StringBuilder lastWord;
	private int sumOfLengths;

	/**
	 * 
	 * @param input     The input reader. Won't be closed by running
	 *                  {@link #count()} method.
	 * @param stopwords Collection of stopwords, if they are repeated, duplicates
	 *                  will be ignored.
	 */
	public WordCounter(Reader input, Collection<String> stopwords) {
		this.words = new HashSet<String>();
		this.stopwords = new HashSet<String>(stopwords);
		this.input = input;
		this.lastWord = null;
		this.lastWordLegal = true;
		this.count = NOT_KNOWN;
	}

	private boolean isSeparator(int character) {
		for (int separator : SEPARATORS) {
			if (character == separator) {
				return true;
			}
		}
		return false;
	}

	private boolean isLegalChar(int character) {
		return character == DASH || (character >= LOWER_A && character <= LOWER_Z)
				|| (character >= UPPER_A && character <= UPPER_Z);
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

	private boolean lastWordCounts() {
		return lastWordLegal && !isLastWordStopWord();
	}

	private void recordLastWord() {
		count++;
		String word = lastWord.toString();
		this.words.add(word);
		this.sumOfLengths += word.length();
	}

	public int count() {
		if (count == NOT_KNOWN) {
			processInput();
		}
		return count;
	}

	public int uniqueCount() {
		if (count == NOT_KNOWN) {
			processInput();
		}
		return words.size();
	}

	public double averageLength() {
		if (count == NOT_KNOWN) {
			processInput();
		}
		double sum = (double) this.sumOfLengths;
		double count = (double) this.count;
		return sum / count;
	}

	private int processInput() {
		try {
			this.count = 0;
			boolean inSeparator = true;
			int c;
			while ((c = input.read()) != -1) {
				if (isSeparator(c)) {
					if (!inSeparator) {
						if (lastWordCounts()) {
							recordLastWord();
						}
						inSeparator = true;
						lastWordLegal = true;
						discardLastWord();
					}
				} else {
					if (!isLegalChar(c)) {
						lastWordLegal = false;
					}
					inSeparator = false;
					appendToLastWord(c);
				}
			}
			if (!inSeparator && lastWordCounts()) {
				recordLastWord();
			}
			return count;
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
