package exception;

public class InvalidPaymentException extends Exception {

    public InvalidPaymentException() {

        super("Invalid payment details.");

    }

    public InvalidPaymentException(String message) {

        super(message);

    }

}