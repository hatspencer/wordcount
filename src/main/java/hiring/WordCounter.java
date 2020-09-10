package hiring;

public interface WordCounter {

    WordCount countWords(String text);

    class WordCount {

        private final int total;
        private final int unique;
        private final float averageWordLength;

        public WordCount(int total, int unique, float averageWordLength) {
            this.total = total;
            this.unique = unique;
            this.averageWordLength = averageWordLength;
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
    }
}
