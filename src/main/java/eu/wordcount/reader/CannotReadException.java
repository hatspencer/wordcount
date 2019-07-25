package eu.wordcount.reader;

public class CannotReadException extends RuntimeException {

    public CannotReadException(String message) {
        super(message);
    }

    public CannotReadException(String msg, Exception e) {
        super(msg, e);
    }
}
