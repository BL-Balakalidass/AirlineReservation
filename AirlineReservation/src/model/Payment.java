package model;

public interface Payment {

    // Validate payment details
    boolean validatePayment();

    // Process payment
    boolean processPayment(double amount);

    // Refund payment
    boolean refundPayment(double amount);

}