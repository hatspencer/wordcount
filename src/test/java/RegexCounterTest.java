import api.WordCounter;
import impl.RegexCounter;

public class RegexCounterTest {

	public static void main(String[] args) {
		String[] inputs = new String[]{"", null, "   ", "one", "one two.word", "? word word.", "Mary had a little lamb", "word?one.two three"};
		int[] expectedResults = new int[]{0, 0, 0, 1, 2, 2, 5, 4};

		WordCounter counter = new RegexCounter();
		for (int i = 0; i < inputs.length; i++) {
			int count = counter.count(inputs[i]);
			if (count != expectedResults[i]) {
				System.err.println("Expected different word count! Expected " + expectedResults[i] + " and got " + count + " for input '" + inputs[i] + "'");
			} else {
				System.out.println("Correct!");
			}
		}
	}
}