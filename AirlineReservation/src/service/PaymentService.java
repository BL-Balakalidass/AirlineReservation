package service;

import model.Booking;
import model.Payment;
import model.PaymentStatus;
import service.PaymentManager;
import model.Payment;
import service.NotificationService;
import service.BusinessRuleService;
import exception.PaymentFailureException;
import exception.NetworkTimeoutException;
import exception.DatabaseConnectionException;
import exception.InvalidPaymentException;
import manager.NotificationManager;
import service.PaymentGatewayService;
import service.ExceptionLogger;

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
    // --------------------------------------
// Process Refund
// --------------------------------------

    public void processRefund(double amount) {

        System.out.println();

        System.out.println(
                "Refund Initiated");

        System.out.println(
                "Refund Amount : ₹" + amount);

        System.out.println(
                "Refund Successful.");

    }

    // --------------------------------------
// Save Payment
// --------------------------------------

    public void savePayment(Payment payment) {

        PaymentManager
                .getInstance()
                .addPayment(payment);

    }

// --------------------------------------
// Find Payment
// --------------------------------------

    public Payment findPayment(String transactionId) {

        return PaymentManager
                .getInstance()
                .getPayment(transactionId);

    }

// --------------------------------------
// Delete Payment
// --------------------------------------

    public void deletePayment(String transactionId) {

        PaymentManager
                .getInstance()
                .removePayment(transactionId);

    }

// --------------------------------------
// Display Cached Payments
// --------------------------------------

    public void displayCachedPayments() {

        PaymentManager
                .getInstance()
                .displayPayments();

    }

    private NotificationService notificationService =
            new NotificationService();
    // --------------------------------------
// Payment Receipt Notification
// --------------------------------------

    public void notifyPaymentSuccess(Booking booking) {

        if (booking == null) {

            return;

        }

        notificationService.sendPaymentReceipt(
                booking);

    }

    public void notifyWhatsApp(Booking booking) {

        notificationService.sendWhatsAppNotification(
                booking);

    }


    private BusinessRuleService businessRuleService =
            new BusinessRuleService();

    // =====================================================
// CALCULATE FINAL PAYMENT
// =====================================================

    public double calculateFinalPayment(
            Booking booking,
            double excessWeight,
            boolean premiumSeat,
            boolean upgradedMeal,
            String couponCode) {

        if (booking == null) {

            return 0;

        }

        double amount =
                businessRuleService.calculateFinalFare(
                        booking.getFlight(),
                        excessWeight,
                        premiumSeat,
                        upgradedMeal,
                        couponCode);

        booking.setTotalAmount(amount);

        return amount;

    }
    // =====================================================
// APPLY COUPON
// =====================================================

    public double applyCouponDiscount(
            Booking booking,
            String couponCode) {

        if (booking == null) {

            return 0;

        }

        double amount =
                businessRuleService.applyCoupon(
                        couponCode,
                        booking.getTotalAmount());

        booking.setTotalAmount(amount);

        return amount;

    }
    private ExceptionLogger logger =
            new ExceptionLogger();

    // =====================================================
// VALIDATE PAYMENT
// =====================================================

    public void validatePayment(
            String cardNumber)
            throws InvalidPaymentException {

        if (cardNumber == null ||
                cardNumber.length() < 12) {

            InvalidPaymentException exception =
                    new InvalidPaymentException();

            logger.logException(exception);

            throw exception;

        }

        logger.logInfo(
                "Payment details validated.");

    }

    // =====================================================
// PAYMENT FAILURE
// =====================================================

    public void simulatePaymentFailure()
            throws PaymentFailureException {

        PaymentFailureException exception =
                new PaymentFailureException();

        logger.logException(exception);

        throw exception;

    }

    // =====================================================
// NETWORK TIMEOUT
// =====================================================

    public void simulateNetworkTimeout()
            throws NetworkTimeoutException {

        NetworkTimeoutException exception =
                new NetworkTimeoutException();

        logger.logException(exception);

        throw exception;

    }

    // =====================================================
// DATABASE FAILURE
// =====================================================

    public void simulateDatabaseFailure()
            throws DatabaseConnectionException {

        DatabaseConnectionException exception =
                new DatabaseConnectionException();

        logger.logException(exception);

        throw exception;

    }

    private final PaymentGatewayService gatewayService =
            new PaymentGatewayService();

    private final NotificationManager notificationManager =
            NotificationManager.getInstance();

    // =====================================================
// PAY USING RAZORPAY
// =====================================================

    public boolean payUsingRazorpay(
            Booking booking,
            double amount) {

        boolean status =
                gatewayService.processRazorpay(
                        booking,
                        amount);

        if (status) {

            notificationManager
                    .sendPaymentReceipt(
                            booking,
                            amount);

        }

        return status;

    }

    // =====================================================
// PAY USING PAYU
// =====================================================

    public boolean payUsingPayU(
            Booking booking,
            double amount) {

        boolean status =
                gatewayService.processPayU(
                        booking,
                        amount);

        if (status) {

            notificationManager
                    .sendPaymentReceipt(
                            booking,
                            amount);

        }

        return status;

    }
    // =====================================================
// PAY USING CCAVENUE
// =====================================================

    public boolean payUsingCCAvenue(
            Booking booking,
            double amount) {

        boolean status =
                gatewayService.processCCAvenue(
                        booking,
                        amount);

        if (status) {

            notificationManager
                    .sendPaymentReceipt(
                            booking,
                            amount);

        }

        return status;

    }

    // =====================================================
// REFUND PAYMENT
// =====================================================

    public void refundPayment(
            Booking booking,
            double amount) {

        gatewayService.refundPayment(
                booking,
                amount);

        notificationManager
                .sendRefundNotification(
                        booking,
                        amount);

    }
}