package exception;

public class PaymentFailureException extends Exception {

    public PaymentFailureException() {

        super("Payment processing failed.");

    }

    public PaymentFailureException(String message) {

        super(message);

    }

}