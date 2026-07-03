package service;

import model.Booking;
import model.Payment;
import model.PaymentStatus;

import java.util.UUID;

public class PaymentService {

    // Display Fare Summary
    public void displayFareSummary(Booking booking) {

        System.out.println("\n========== FARE SUMMARY ==========");
        System.out.println("PNR         : " + booking.getPnr());
        System.out.println("Total Fare  : ₹" + booking.getTotalFare());
        System.out.println("==================================");
    }

    // Apply Discount
    public double applyDiscount(Booking booking, String promoCode) {

        double total = booking.getTotalFare();

        if (promoCode != null && promoCode.equalsIgnoreCase("SAVE10")) {

            total = total - (total * 0.10);

            System.out.println("Promo Applied : SAVE10");
            System.out.println("10% Discount Applied");
        }
        else {

            System.out.println("No Discount Applied");
        }

        return total;
    }

    // Process Payment
    public boolean processPayment(Booking booking,
                                  Payment payment,
                                  String promoCode) {

        double amount = applyDiscount(booking, promoCode);

        if (!payment.validatePayment()) {

            booking.setPaymentStatus(PaymentStatus.FAILED);

            System.out.println("Payment Validation Failed.");

            return false;
        }

        boolean success = payment.processPayment(amount);

        if (success) {

            booking.setPaymentStatus(PaymentStatus.SUCCESS);

            booking.setTransactionId(generateTransactionId());

            booking.completePayment();

            System.out.println("Transaction ID : "
                    + booking.getTransactionId());

            return true;
        }

        booking.setPaymentStatus(PaymentStatus.FAILED);

        return false;
    }

    // Refund
    public void refundPayment(Booking booking,
                              Payment payment) {

        if (booking.getPaymentStatus() != PaymentStatus.SUCCESS) {

            System.out.println("Refund Cannot Be Processed.");
            return;
        }

        double refundAmount = booking.getTotalFare();

        payment.refundPayment(refundAmount);

        booking.setPaymentStatus(PaymentStatus.REFUNDED);

        System.out.println("Refund Completed.");
    }

    // Display Payment Status
    public void displayPayment(Booking booking) {

        System.out.println("\n========== PAYMENT ==========");

        System.out.println("PNR              : " + booking.getPnr());

        System.out.println("Payment Status   : "
                + booking.getPaymentStatus());

        System.out.println("Transaction ID   : "
                + booking.getTransactionId());

        System.out.println("=============================");
    }

    // Generate Transaction ID
    private String generateTransactionId() {

        return "TXN"
                + UUID.randomUUID()
                .toString()
                .substring(0,8)
                .toUpperCase();

    }
    // --------------------------------------
// Additional Payment
// --------------------------------------

    public void additionalPayment(double amount) {

        System.out.println();

        System.out.println("Additional Payment Required");

        System.out.println("Amount : ₹" + amount);

        System.out.println("Payment Successful.");

    }

// --------------------------------------
// Refund Difference
// --------------------------------------

    public void refundDifference(double amount) {

        System.out.println();

        System.out.println("Refund Initiated");

        System.out.println("Refund Amount : ₹" + amount);

        System.out.println("Refund Successful.");

    }

}