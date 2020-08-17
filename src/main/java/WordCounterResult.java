public final class WordCounterResult {

    private final long count;
    private final long unique;

    public WordCounterResult(long count) {
        this.count = count;
        this.unique = -1;
    }

    public WordCounterResult(long count, long unique) {
        this.count = count;
        this.unique = unique;
    }

    public long getCount() {
        return count;
    }

}
