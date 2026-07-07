package exception;

public class BookingNotFoundException extends Exception {

    public BookingNotFoundException() {

        super("Booking not found.");

    }

    public BookingNotFoundException(String message) {

        super(message);

    }

}