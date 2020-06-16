package hiring.wordcounter;

import java.util.List;

public class WordLengthCounterImpl implements WordLengthCounter {

	@Override
	public double countAverageWordLength(List<String> words) {
		double sumCharacters = words.stream().map(String::length).reduce(0, Integer::sum);
		return sumCharacters / words.size();
	}

}
