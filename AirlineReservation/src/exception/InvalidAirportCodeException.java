package exception;

public class InvalidAirportCodeException extends Exception {

    public InvalidAirportCodeException() {

        super("Invalid airport code.");

    }

    public InvalidAirportCodeException(String message) {

        super(message);

    }

}