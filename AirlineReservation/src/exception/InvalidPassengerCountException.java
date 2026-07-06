package exception;

public class InvalidPassengerCountException extends Exception {

    public InvalidPassengerCountException() {

        super("Invalid passenger count.");

    }

    public InvalidPassengerCountException(String message) {

        super(message);

    }

}