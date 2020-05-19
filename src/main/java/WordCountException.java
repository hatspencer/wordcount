public class WordCountException extends RuntimeException {

    public WordCountException() {
    }

    public WordCountException(String message) {
        super(message);
    }

    public WordCountException(String message, Throwable cause) {
        super(message, cause);
    }
}
