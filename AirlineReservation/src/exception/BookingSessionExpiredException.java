package exception;

public class BookingSessionExpiredException extends Exception {

    public BookingSessionExpiredException() {

        super("Booking session has expired.");

    }

    public BookingSessionExpiredException(String message) {

        super(message);

    }

}