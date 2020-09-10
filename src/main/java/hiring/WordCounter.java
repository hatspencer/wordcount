package hiring;

import java.util.Set;

public interface WordCounter {

    WordCount countWords(String text);

    class WordCount {

        private final int total;
        private final int unique;
        private final float averageWordLength;
        private final Set<String> index;

        public WordCount(int total, int unique, float averageWordLength, Set<String> index) {
            this.total = total;
            this.unique = unique;
            this.averageWordLength = averageWordLength;
            this.index = index;
        }

        public int getTotal() {
            return total;
        }

        public int getUnique() {
            return unique;
        }

        public float getAverageWordLength() {
            return averageWordLength;
        }

        public Set<String> getIndex() {
            return index;
        }
    }
}
