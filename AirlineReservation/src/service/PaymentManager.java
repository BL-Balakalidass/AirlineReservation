package service;

import model.Payment;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PaymentManager {

    // ---------------------------------------
    // Singleton Instance
    // ---------------------------------------

    private static PaymentManager instance;

    // ---------------------------------------
    // Payment Cache
    // ---------------------------------------

    private Map<String, Payment> paymentCache;

    // ---------------------------------------
    // Private Constructor
    // ---------------------------------------

    private PaymentManager() {

        paymentCache = new HashMap<>();

    }

    // ---------------------------------------
    // Get Singleton Instance
    // ---------------------------------------

    public static synchronized PaymentManager getInstance() {

        if (instance == null) {

            instance = new PaymentManager();

        }

        return instance;

    }

    // ---------------------------------------
    // Add Payment
    // ---------------------------------------

    public void addPayment(Payment payment) {

        if (payment == null) {

            System.out.println("Invalid Payment.");

            return;

        }

        paymentCache.put(
                payment.getTransactionId(),
                payment
        );

        System.out.println("Payment Saved : "
                + payment.getTransactionId());

    }

    // ---------------------------------------
    // Get Payment
    // ---------------------------------------

    public Payment getPayment(String transactionId) {

        return paymentCache.get(transactionId);

    }

    // ---------------------------------------
    // Remove Payment
    // ---------------------------------------

    public void removePayment(String transactionId) {

        if (paymentCache.remove(transactionId) != null) {

            System.out.println("Payment Removed : "
                    + transactionId);

        } else {

            System.out.println("Payment Not Found.");

        }

    }

    // ---------------------------------------
    // Payment Exists
    // ---------------------------------------

    public boolean containsPayment(String transactionId) {

        return paymentCache.containsKey(transactionId);

    }

    // ---------------------------------------
    // Total Payments
    // ---------------------------------------

    public int getPaymentCount() {

        return paymentCache.size();

    }

    // ---------------------------------------
    // Get All Payments
    // ---------------------------------------

    public Collection<Payment> getAllPayments() {

        return paymentCache.values();

    }

    // ---------------------------------------
    // Display Payments
    // ---------------------------------------

    public void displayPayments() {

        System.out.println();

        System.out.println("========== PAYMENTS ==========");

        if (paymentCache.isEmpty()) {

            System.out.println("No Payments Available.");

            return;

        }

        for (Payment payment : paymentCache.values()) {

            System.out.println("--------------------------------");

            System.out.println("Transaction ID : "
                    + payment.getTransactionId());

            System.out.println("Amount : ₹"
                    + payment.getAmount());

            System.out.println("Status : "
                    + payment.getStatus());

        }

    }

    // ---------------------------------------
    // Clear Cache
    // ---------------------------------------

    public void clearPayments() {

        paymentCache.clear();

        System.out.println("Payment Cache Cleared.");

    }

}