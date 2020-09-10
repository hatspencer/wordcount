package hiring;

public interface WordCounter {

    WordCount countWords(String text);

    class WordCount {

        private final int total;
        private final int unique;

        public WordCount(int total, int unique) {
            this.total = total;
            this.unique = unique;
        }

        public int getTotal() {
            return total;
        }

        public int getUnique() {
            return unique;
        }
    }
}
