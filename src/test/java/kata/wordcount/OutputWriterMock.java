package kata.wordcount;

class OutputWriterMock extends OutputWriter {

    private long numberOfWords;

    @Override
    void writeOutput(long numberOfWords) {
        this.numberOfWords = numberOfWords;
    }

    long getNumberOfWords() {
        return numberOfWords;
    }
}
