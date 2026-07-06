package exception;

public class FlightNotFoundException extends Exception {

    public FlightNotFoundException() {

        super("Flight not found.");

    }

    public FlightNotFoundException(String message) {

        super(message);

    }

}