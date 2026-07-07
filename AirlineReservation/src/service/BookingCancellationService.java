package service;

import model.Booking;
import model.BookingState;
import model.Passenger;
import model.Seat;
import service.NotificationService;

public class BookingCancellationService {

    private PaymentService paymentService;
    private SeatService seatService;

    public BookingCancellationService(PaymentService paymentService,
                                      SeatService seatService) {

        this.paymentService = paymentService;
        this.seatService = seatService;
    }

    // ------------------------------------------
    // Full Booking Cancellation
    // ------------------------------------------

    public void cancelBooking(Booking booking,
                              boolean before24Hours,
                              boolean refundable) {

        if (booking == null) {

            System.out.println("Booking Not Found.");
            return;
        }

        System.out.println("\n========== BOOKING CANCELLATION ==========");

        System.out.println("PNR : " + booking.getPnr());

        double refund =
                calculateRefund(
                        booking.getTotalFare(),
                        before24Hours,
                        refundable);

        booking.setBookingState(
                BookingState.CANCELLED);

        // Release Seats

        for (Seat seat : booking.getSeats()) {

            seatService.releaseSeat(
                    seat.getSeatId());
        }

        // Refund

        paymentService.processRefund(refund);

        System.out.println("Booking Cancelled Successfully.");

        System.out.println("Refund Amount : ₹" + refund);

    }

    // ------------------------------------------
    // Partial Passenger Cancellation
    // ------------------------------------------

    public void cancelPassenger(Booking booking,
                                Passenger passenger) {

        if (booking == null || passenger == null) {

            System.out.println("Invalid Data.");
            return;
        }

        booking.removePassenger(passenger);

        double refund =
                booking.getTotalFare()
                        / (booking.getPassengers().size() + 1);

        paymentService.processRefund(refund);

        System.out.println();

        System.out.println(
                passenger.getFullName()
                        + " removed from booking.");

        System.out.println(
                "Refund Amount : ₹"
                        + refund);

    }

    // ------------------------------------------
    // Refund Calculation
    // ------------------------------------------

    public double calculateRefund(double fare,
                                  boolean before24Hours,
                                  boolean refundable) {

        if (!refundable) {

            return 0;
        }

        double charges =
                calculateCancellationCharge(
                        fare,
                        before24Hours);

        return fare - charges;

    }

    // ------------------------------------------
    // Cancellation Charge
    // ------------------------------------------

    public double calculateCancellationCharge(
            double fare,
            boolean before24Hours) {

        if (before24Hours) {

            return fare * 0.10;

        }

        return fare * 0.30;

    }

    // ------------------------------------------
    // Display Cancellation
    // ------------------------------------------

    public void displayCancellation(
            Booking booking) {

        System.out.println();

        System.out.println(
                "========== CANCELLATION DETAILS ==========");

        booking.displayBooking();

    }

    private NotificationService notificationService =
            new NotificationService();

    // --------------------------------------
// Cancellation Notification
// --------------------------------------

    public void notifyCancellation(Booking booking) {

        if (booking == null) {

            return;

        }

        notificationService
                .sendCancellationConfirmation(
                        booking);

    }

    // --------------------------------------
// Refund Initiated Notification
// --------------------------------------

    public void notifyRefundInitiated(Booking booking,
                                      double amount) {

        notificationService
                .sendRefundInitiated(
                        booking,
                        amount);

    }

    // --------------------------------------
// Refund Completed Notification
// --------------------------------------

    public void notifyRefundCompleted(Booking booking,
                                      double amount) {

        notificationService
                .sendRefundCompleted(
                        booking,
                        amount);

    }

    public void cancelBooking(Booking booking) {
    }

    public double calculateRefundAmount(Booking booking) {
        return 0;
    }
}