package exceptions;

public class ConcertAlreadyAttendedException extends Exception {
    public ConcertAlreadyAttendedException(String message) {
        super(message);
    }
}