package service;

import model.Booking;
import model.Flight;
import model.Passenger;
import manager.NotificationManager;

public class NotificationService {

    // ----------------------------------------
    // Booking Confirmation Email
    // ----------------------------------------

    public void sendBookingConfirmation(Booking booking) {

        if (booking == null) {

            System.out.println("Booking not found.");
            return;

        }

        Passenger passenger = (Passenger) booking.getPassenger();

        System.out.println("\n========== EMAIL ==========");
        System.out.println("To : " + passenger.getEmail());
        System.out.println("Subject : Booking Confirmation");
        System.out.println("Dear " + passenger.getFullName() + ",");
        System.out.println("Your booking is confirmed.");
        System.out.println("PNR : " + booking.getPnr());
        System.out.println("E-Ticket : " + booking.getETicketNumber());
        System.out.println("===========================\n");

    }

    // ----------------------------------------
    // Booking Confirmation SMS
    // ----------------------------------------

    public void sendBookingSMS(Booking booking) {

        if (booking == null) {

            return;

        }

        Passenger passenger = (Passenger) booking.getPassenger();

        System.out.println("SMS Sent To : " + passenger.getPhone());

        System.out.println("Booking Confirmed.");

        System.out.println("PNR : " + booking.getPnr());

    }

    // ----------------------------------------
    // Payment Receipt
    // ----------------------------------------

    public void sendPaymentReceipt(Booking booking) {

        if (booking == null) {

            return;

        }

        Passenger passenger = (Passenger) booking.getPassenger();

        System.out.println();

        System.out.println("Payment Receipt");

        System.out.println("Email : "
                + passenger.getEmail());

        System.out.println("Amount : ₹"
                + booking.getTotalFare());

    }

    // ----------------------------------------
    // WhatsApp Notification
    // ----------------------------------------

    public void sendWhatsAppNotification(Booking booking) {

        if (booking == null) {

            return;

        }

        Passenger passenger = (Passenger) booking.getPassenger();

        System.out.println();

        System.out.println("WhatsApp Notification");

        System.out.println("To : "
                + passenger.getPhone());

        System.out.println("Your booking is confirmed.");

    }

    // ----------------------------------------
    // Flight Delay
    // ----------------------------------------

    public void sendDelayNotification(Flight flight) {

        if (flight == null) {

            return;

        }

        System.out.println();

        System.out.println("Flight Delay Notification");

        System.out.println("Flight : "
                + flight.getFlightNumber());

        System.out.println("Please check latest schedule.");

    }

    // ----------------------------------------
    // Gate Change
    // ----------------------------------------

    public void sendGateChangeNotification(Flight flight,
                                           String gate) {

        if (flight == null) {

            return;

        }

        System.out.println();

        System.out.println("Gate Change Notification");

        System.out.println("Flight : "
                + flight.getFlightNumber());

        System.out.println("New Gate : "
                + gate);

    }

    // ----------------------------------------
    // Flight Cancellation
    // ----------------------------------------

    public void sendCancellationAlert(Flight flight) {

        if (flight == null) {

            return;

        }

        System.out.println();

        System.out.println("Flight Cancelled");

        System.out.println("Flight : "
                + flight.getFlightNumber());

    }

    // ----------------------------------------
    // Check-In Reminder
    // ----------------------------------------

    public void sendCheckInReminder(Booking booking) {

        if (booking == null) {

            return;

        }

        System.out.println();

        System.out.println("Check-in Reminder");

        System.out.println("PNR : "
                + booking.getPnr());

        System.out.println("Check-in opens 24 hours before departure.");

    }

    // ----------------------------------------
    // Boarding Reminder
    // ----------------------------------------

    public void sendBoardingReminder(Booking booking) {

        if (booking == null) {

            return;

        }

        System.out.println();

        System.out.println("Boarding Reminder");

        System.out.println("PNR : "
                + booking.getPnr());

        System.out.println("Please arrive 3 hours before departure.");

    }

    // ----------------------------------------
    // Booking Modification
    // ----------------------------------------

    public void sendModificationConfirmation(Booking booking) {

        if (booking == null) {

            return;

        }

        System.out.println();

        System.out.println("Booking Modified");

        System.out.println("Updated E-Ticket : "
                + booking.getETicketNumber());

    }

    // ----------------------------------------
    // Booking Cancellation
    // ----------------------------------------

    public void sendCancellationConfirmation(Booking booking) {

        if (booking == null) {

            return;

        }

        System.out.println();

        System.out.println("Booking Cancelled");

        System.out.println("PNR : "
                + booking.getPnr());

    }

    // ----------------------------------------
    // Refund Initiated
    // ----------------------------------------

    public void sendRefundInitiated(Booking booking,
                                    double amount) {

        if (booking == null) {

            return;

        }

        System.out.println();

        System.out.println("Refund Initiated");

        System.out.println("PNR : "
                + booking.getPnr());

        System.out.println("Amount : ₹"
                + amount);

    }

    // ----------------------------------------
    // Refund Completed
    // ----------------------------------------

    public void sendRefundCompleted(Booking booking,
                                    double amount) {

        if (booking == null) {

            return;

        }

        System.out.println();

        System.out.println("Refund Completed");

        System.out.println("PNR : "
                + booking.getPnr());

        System.out.println("Amount Credited : ₹"
                + amount);

    }
    private final NotificationManager manager =
            NotificationManager.getInstance();




    // =====================================================
// SEND PAYMENT RECEIPT
// =====================================================

    public void sendPaymentReceipt(
            Booking booking,
            double amount) {

        manager.sendPaymentReceipt(
                booking,
                amount);

    }
    // =====================================================
// SEND CANCELLATION
// =====================================================

    public void sendCancellation(
            Booking booking) {

        manager.sendCancellation(
                booking);

    }
    // =====================================================
// SEND FLIGHT DELAY
// =====================================================

    public void sendFlightDelay(
            Booking booking,
            String delay) {

        manager.sendFlightDelayNotification(
                booking,
                delay);

    }



}