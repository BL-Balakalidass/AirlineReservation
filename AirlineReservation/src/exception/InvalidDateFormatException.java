package exception;

public class InvalidDateFormatException extends Exception {

    public InvalidDateFormatException() {

        super("Invalid date format.");

    }

    public InvalidDateFormatException(String message) {

        super(message);

    }

}