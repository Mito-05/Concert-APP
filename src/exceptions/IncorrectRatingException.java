package exceptions;

public class IncorrectRatingException extends Exception {
    public IncorrectRatingException(String message) {
        super(message);
    }
}