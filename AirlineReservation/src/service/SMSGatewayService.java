package service;

import model.Booking;
import model.Passenger;

import java.time.LocalDateTime;

public class SMSGatewayService {

    // =====================================================
    // SMS GATEWAY
    // =====================================================

    private static final String PROVIDER =
            "Twilio SMS Gateway";

    // =====================================================
    // SEND SMS
    // =====================================================

    public boolean sendSMS(
            String mobileNumber,
            String message) {

        if (mobileNumber == null ||
                mobileNumber.isBlank()) {

            System.out.println(
                    "Invalid Mobile Number.");

            return false;

        }

        System.out.println(
                "\n====================================");

        System.out.println(
                "SMS GATEWAY");

        System.out.println(
                "====================================");

        System.out.println(
                "Provider : "
                        + PROVIDER);

        System.out.println(
                "To : "
                        + mobileNumber);

        System.out.println(
                "Time : "
                        + LocalDateTime.now());

        System.out.println(
                "Message : "
                        + message);

        System.out.println(
                "Status : SENT");

        return true;

    }

    // =====================================================
    // SEND OTP
    // =====================================================

    public boolean sendOTP(
            String mobileNumber,
            String otp) {

        return sendSMS(
                mobileNumber,
                "Your OTP for Airline Reservation is : "
                        + otp);

    }

    // =====================================================
    // BOOKING CONFIRMATION SMS
    // =====================================================

    public boolean sendBookingSMS(
            Booking booking) {

        if (booking == null) {

            return false;

        }

        Passenger passenger =
                booking.getPassenger();

        String mobile =
                passenger.getPhoneNumber();

        StringBuilder builder =
                new StringBuilder();

        builder.append("Booking Confirmed\n");

        builder.append("PNR : ")
                .append(booking.getPnr())
                .append("\n");

        builder.append("Flight : ")
                .append(booking.getFlight()
                        .getFlightNumber())
                .append("\n");

        builder.append("Thank you for choosing us.");

        return sendSMS(
                mobile,
                builder.toString());

    }

    // =====================================================
    // CANCELLATION SMS
    // =====================================================

    public boolean sendCancellationSMS(
            Booking booking) {

        if (booking == null) {

            return false;

        }

        Passenger passenger =
                booking.getPassenger();

        String mobile =
                passenger.getPhoneNumber();

        StringBuilder builder =
                new StringBuilder();

        builder.append("Booking Cancelled\n");

        builder.append("PNR : ")
                .append(booking.getPnr())
                .append("\n");

        builder.append("Refund will be processed shortly.");

        return sendSMS(
                mobile,
                builder.toString());

    }

    // =====================================================
    // CHECK-IN REMINDER
    // =====================================================

    public boolean sendCheckInReminder(
            Booking booking) {

        if (booking == null) {

            return false;

        }

        return sendSMS(
                booking.getPassenger()
                        .getPhoneNumber(),
                "Reminder: Online Check-in is now available for PNR "
                        + booking.getPnr());

    }

    // =====================================================
    // BOARDING REMINDER
    // =====================================================

    public boolean sendBoardingReminder(
            Booking booking) {

        if (booking == null) {

            return false;

        }

        return sendSMS(
                booking.getPassenger()
                        .getPhoneNumber(),
                "Boarding starts soon for Flight "
                        + booking.getFlight()
                        .getFlightNumber());

    }

    // =====================================================
    // FLIGHT DELAY ALERT
    // =====================================================

    public boolean sendDelayAlert(
            Booking booking,
            String delayTime) {

        if (booking == null) {

            return false;

        }

        return sendSMS(
                booking.getPassenger()
                        .getPhoneNumber(),
                "Flight "
                        + booking.getFlight()
                        .getFlightNumber()
                        + " delayed by "
                        + delayTime);

    }

    // =====================================================
    // GATE CHANGE ALERT
    // =====================================================

    public boolean sendGateChangeAlert(
            Booking booking,
            String gateNumber) {

        if (booking == null) {

            return false;

        }

        return sendSMS(
                booking.getPassenger()
                        .getPhoneNumber(),
                "Gate changed to "
                        + gateNumber
                        + " for Flight "
                        + booking.getFlight()
                        .getFlightNumber());

    }

    // =====================================================
    // DISPLAY PROVIDER
    // =====================================================

    public void displayProvider() {

        System.out.println(
                "\nSMS Gateway Provider : "
                        + PROVIDER);

    }

}