package service;

import model.Booking;
import model.Passenger;

import java.time.LocalDateTime;

public class EmailGatewayService {

    // =====================================================
    // EMAIL SERVICE PROVIDER
    // =====================================================

    private static final String PROVIDER =
            "SMTP Email Service";

    private static final String FROM_EMAIL =
            "noreply@airlinereservation.com";

    // =====================================================
    // SEND EMAIL
    // =====================================================

    public boolean sendEmail(
            String toEmail,
            String subject,
            String message) {

        if (toEmail == null ||
                toEmail.isBlank()) {

            System.out.println(
                    "Invalid Email Address.");

            return false;

        }

        System.out.println(
                "\n====================================");

        System.out.println(
                "EMAIL SERVICE");

        System.out.println(
                "====================================");

        System.out.println(
                "Provider : "
                        + PROVIDER);

        System.out.println(
                "From : "
                        + FROM_EMAIL);

        System.out.println(
                "To : "
                        + toEmail);

        System.out.println(
                "Subject : "
                        + subject);

        System.out.println(
                "Time : "
                        + LocalDateTime.now());

        System.out.println(
                "\nMessage");

        System.out.println(
                "------------------------------------");

        System.out.println(message);

        System.out.println(
                "------------------------------------");

        System.out.println(
                "Status : SENT");

        return true;

    }

    // =====================================================
    // BOOKING CONFIRMATION EMAIL
    // =====================================================

    public boolean sendBookingEmail(
            Booking booking) {

        if (booking == null) {

            return false;

        }

        Passenger passenger =
                booking.getPassenger();

        StringBuilder body =
                new StringBuilder();

        body.append("Dear ")
                .append(passenger.getFullName())
                .append(",\n\n");

        body.append("Your booking has been confirmed.\n\n");

        body.append("PNR : ")
                .append(booking.getPnr())
                .append("\n");

        body.append("Flight : ")
                .append(booking.getFlight()
                        .getFlightNumber())
                .append("\n");

        body.append("Departure : ")
                .append(booking.getFlight()
                        .getSource())
                .append("\n");

        body.append("Arrival : ")
                .append(booking.getFlight()
                        .getDestination())
                .append("\n\n");

        body.append("Thank you for choosing our airline.");

        return sendEmail(
                passenger.getEmail(),
                "Booking Confirmation",
                body.toString());

    }

    // =====================================================
    // BOARDING PASS EMAIL
    // =====================================================

    public boolean sendBoardingPass(
            Booking booking) {

        if (booking == null) {

            return false;

        }

        Passenger passenger =
                booking.getPassenger();

        StringBuilder body =
                new StringBuilder();

        body.append("Dear ")
                .append(passenger.getFullName())
                .append(",\n\n");

        body.append("Your boarding pass is ready.\n\n");

        body.append("PNR : ")
                .append(booking.getPnr())
                .append("\n");

        body.append("Flight : ")
                .append(booking.getFlight()
                        .getFlightNumber())
                .append("\n");

        body.append("Seat : ")
                .append(booking.getSeatNumber())
                .append("\n\n");

        body.append("Please arrive at the airport ")
                .append("at least 2 hours before departure.");

        return sendEmail(
                passenger.getEmail(),
                "Boarding Pass",
                body.toString());

    }

    // =====================================================
    // PAYMENT RECEIPT EMAIL
    // =====================================================

    public boolean sendPaymentReceipt(
            Booking booking,
            double amount) {

        if (booking == null) {

            return false;

        }

        Passenger passenger =
                booking.getPassenger();

        StringBuilder body =
                new StringBuilder();

        body.append("Payment Successful\n\n");

        body.append("PNR : ")
                .append(booking.getPnr())
                .append("\n");

        body.append("Amount Paid : ₹")
                .append(amount)
                .append("\n");

        body.append("Status : SUCCESS\n\n");

        body.append("Thank you.");

        return sendEmail(
                passenger.getEmail(),
                "Payment Receipt",
                body.toString());

    }

    // =====================================================
    // REFUND EMAIL
    // =====================================================

    public boolean sendRefundEmail(
            Booking booking,
            double refundAmount) {

        if (booking == null) {

            return false;

        }

        Passenger passenger =
                booking.getPassenger();

        StringBuilder body =
                new StringBuilder();

        body.append("Refund Initiated\n\n");

        body.append("PNR : ")
                .append(booking.getPnr())
                .append("\n");

        body.append("Refund Amount : ₹")
                .append(refundAmount)
                .append("\n");

        body.append("The refund will be credited ")
                .append("within 5-7 working days.");

        return sendEmail(
                passenger.getEmail(),
                "Refund Initiated",
                body.toString());

    }

    // =====================================================
    // CANCELLATION EMAIL
    // =====================================================

    public boolean sendCancellationEmail(
            Booking booking) {

        if (booking == null) {

            return false;

        }

        Passenger passenger =
                booking.getPassenger();

        StringBuilder body =
                new StringBuilder();

        body.append("Dear ")
                .append(passenger.getFullName())
                .append(",\n\n");

        body.append("Your booking has been cancelled.\n\n");

        body.append("PNR : ")
                .append(booking.getPnr())
                .append("\n");

        body.append("Refund will be processed shortly.\n\n");

        body.append("Thank you.");

        return sendEmail(
                passenger.getEmail(),
                "Booking Cancellation",
                body.toString());

    }

    // =====================================================
    // FLIGHT DELAY EMAIL
    // =====================================================

    public boolean sendDelayNotification(
            Booking booking,
            String delayTime) {

        if (booking == null) {

            return false;

        }

        Passenger passenger =
                booking.getPassenger();

        String message =
                "Flight "
                        + booking.getFlight()
                        .getFlightNumber()
                        + " has been delayed by "
                        + delayTime
                        + ".";

        return sendEmail(
                passenger.getEmail(),
                "Flight Delay Notification",
                message);

    }

    // =====================================================
    // DISPLAY PROVIDER
    // =====================================================

    public void displayProvider() {

        System.out.println(
                "\nEmail Service Provider : "
                        + PROVIDER);

    }

}