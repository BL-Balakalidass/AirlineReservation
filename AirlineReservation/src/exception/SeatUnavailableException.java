package exception;

public class SeatUnavailableException extends Exception {

    public SeatUnavailableException() {

        super("Requested seat is unavailable.");

    }

    public SeatUnavailableException(String message) {

        super(message);

    }

}