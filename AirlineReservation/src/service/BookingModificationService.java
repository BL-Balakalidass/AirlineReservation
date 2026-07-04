package service;

import model.Booking;
import model.Flight;
import model.Passenger;
import model.Seat;
import service.NotificationService;

public class BookingModificationService {

    private PaymentService paymentService;

    public BookingModificationService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // -------------------------------------------------
    // Change Flight
    // -------------------------------------------------

    public void changeFlight(Booking booking,
                             Flight newFlight,
                             double modificationCharge) {

        if (booking == null || newFlight == null) {
            System.out.println("Booking or Flight not found.");
            return;
        }

        double oldFare = booking.getFlight().getFare();
        double newFare = newFlight.getFare();

        System.out.println("\n========== FLIGHT MODIFICATION ==========");
        System.out.println("Old Flight : "
                + booking.getFlight().getFlightNumber());

        System.out.println("New Flight : "
                + newFlight.getFlightNumber());

        double difference =
                (newFare - oldFare) + modificationCharge;

        if (difference > 0) {

            System.out.println("Additional Payment : ₹"
                    + difference);

            paymentService.additionalPayment(difference);

        } else if (difference < 0) {

            System.out.println("Refund Amount : ₹"
                    + Math.abs(difference));

            paymentService.refundDifference(
                    Math.abs(difference));

        } else {

            System.out.println("No Fare Difference.");
        }

        booking.setFlight(newFlight);

        booking.calculateFare();

        System.out.println("Flight Updated Successfully.");
    }

    // -------------------------------------------------
    // Passenger Modification
    // -------------------------------------------------

    public void modifyPassenger(Passenger passenger,
                                String email,
                                String phone,
                                String meal,
                                String assistance) {

        if (passenger == null) {

            System.out.println("Passenger not found.");
            return;
        }

        passenger.setEmail(email);
        passenger.setPhone(phone);
        passenger.setPreferredMeal(meal);
        passenger.setSpecialAssistance(assistance);

        System.out.println("\nPassenger Details Updated.");
    }

    // -------------------------------------------------
    // Seat Change
    // -------------------------------------------------

    public void changeSeat(Booking booking,
                           Seat oldSeat,
                           Seat newSeat,
                           double seatCharge) {

        if (booking == null ||
                oldSeat == null ||
                newSeat == null) {

            System.out.println("Seat Change Failed.");
            return;
        }

        booking.removeSeat(oldSeat);

        booking.addSeat(newSeat);

        if (seatCharge > 0) {

            System.out.println(
                    "Seat Upgrade Charge : ₹"
                            + seatCharge);

            paymentService.additionalPayment(
                    seatCharge);

        }

        booking.calculateFare();

        System.out.println(
                "Seat Changed Successfully.");
    }

    // -------------------------------------------------
    // Modification Charge
    // -------------------------------------------------

    public double calculateModificationCharge(
            boolean within24Hours) {

        if (within24Hours) {

            return 1000;

        }

        return 500;
    }

    // -------------------------------------------------
    // Display Booking
    // -------------------------------------------------

    public void displayModification(
            Booking booking) {

        System.out.println();

        System.out.println(
                "========== UPDATED BOOKING ==========");

        booking.displayBooking();

    }

    private NotificationService notificationService =
            new NotificationService();

    // --------------------------------------
// Modification Notification
// --------------------------------------

    public void notifyModification(Booking booking) {

        if (booking == null) {

            return;

        }

        notificationService
                .sendModificationConfirmation(
                        booking);

    }
}