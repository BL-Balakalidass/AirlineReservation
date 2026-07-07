package service;

import model.Booking;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentGatewayService {

    // =====================================================
    // PAYMENT GATEWAYS
    // =====================================================

    private static final String RAZORPAY =
            "Razorpay";

    private static final String PAYU =
            "PayU";

    private static final String CCAVENUE =
            "CCAvenue";

    // =====================================================
    // PROCESS RAZORPAY PAYMENT
    // =====================================================

    public boolean processRazorpay(
            Booking booking,
            double amount) {

        return processPayment(
                RAZORPAY,
                booking,
                amount);

    }

    // =====================================================
    // PROCESS PAYU PAYMENT
    // =====================================================

    public boolean processPayU(
            Booking booking,
            double amount) {

        return processPayment(
                PAYU,
                booking,
                amount);

    }

    // =====================================================
    // PROCESS CCAVENUE PAYMENT
    // =====================================================

    public boolean processCCAvenue(
            Booking booking,
            double amount) {

        return processPayment(
                CCAVENUE,
                booking,
                amount);

    }

    // =====================================================
    // COMMON PAYMENT PROCESSOR
    // =====================================================

    private boolean processPayment(
            String gateway,
            Booking booking,
            double amount) {

        if (booking == null) {

            System.out.println(
                    "Booking not available.");

            return false;

        }

        System.out.println(
                "\n====================================");

        System.out.println(
                gateway.toUpperCase()
                        + " PAYMENT");

        System.out.println(
                "====================================");

        System.out.println(
                "Gateway : "
                        + gateway);

        System.out.println(
                "PNR : "
                        + booking.getPnr());

        System.out.println(
                "Amount : ₹"
                        + amount);

        System.out.println(
                "Transaction Time : "
                        + LocalDateTime.now());

        String transactionId =
                generateTransactionId();

        System.out.println(
                "Transaction ID : "
                        + transactionId);

        System.out.println(
                "Payment Status : SUCCESS");

        return true;

    }

    // =====================================================
    // VERIFY PAYMENT
    // =====================================================

    public boolean verifyPayment(
            String transactionId) {

        System.out.println(
                "\nVerifying Payment...");

        if (transactionId == null ||
                transactionId.isBlank()) {

            System.out.println(
                    "Invalid Transaction ID.");

            return false;

        }

        System.out.println(
                "Transaction Verified.");

        return true;

    }

    // =====================================================
    // REFUND PAYMENT
    // =====================================================

    public boolean refundPayment(
            Booking booking,
            double amount) {

        if (booking == null) {

            return false;

        }

        System.out.println(
                "\n====================================");

        System.out.println(
                "PAYMENT REFUND");

        System.out.println(
                "====================================");

        System.out.println(
                "PNR : "
                        + booking.getPnr());

        System.out.println(
                "Refund Amount : ₹"
                        + amount);

        System.out.println(
                "Refund Reference : "
                        + generateTransactionId());

        System.out.println(
                "Refund Status : INITIATED");

        return true;

    }

    // =====================================================
    // GENERATE TRANSACTION ID
    // =====================================================

    public String generateTransactionId() {

        return UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 12)
                .toUpperCase();

    }

    // =====================================================
    // DISPLAY SUPPORTED GATEWAYS
    // =====================================================

    public void displaySupportedGateways() {

        System.out.println(
                "\nSupported Payment Gateways");

        System.out.println(
                "1. Razorpay");

        System.out.println(
                "2. PayU");

        System.out.println(
                "3. CCAvenue");

    }

}