package eu.wordcount;

public class CannotReadException extends Exception {
    public CannotReadException(String msg, Exception e) {
        super(msg, e);
    }
}
