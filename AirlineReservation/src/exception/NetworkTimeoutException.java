package exception;

public class NetworkTimeoutException extends Exception {

    public NetworkTimeoutException() {

        super("Network request timed out.");

    }

    public NetworkTimeoutException(String message) {

        super(message);

    }

}