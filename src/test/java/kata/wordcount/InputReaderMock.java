package kata.wordcount;

class InputReaderMock extends InputReader {

    private String testInput;

    InputReaderMock(String testInput) {
        this.testInput = testInput;
    }

    @Override
    String getInput() {
        return testInput;
    }
}
