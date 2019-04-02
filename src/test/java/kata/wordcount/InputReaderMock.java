package kata.wordcount;

class InputReaderMock extends ConsoleInputReader {

    private String testInput;

    InputReaderMock(String testInput) {
        this.testInput = testInput;
    }

    @Override
    public String read() {
        return testInput;
    }
}
