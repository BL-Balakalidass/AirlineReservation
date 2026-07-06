package service;

import model.Booking;
import model.Passenger;
import model.Seat;

import java.time.Duration;
import java.time.LocalDateTime;

public class CheckInService {

    // =====================================================
    // RETRIEVE BOOKING
    // =====================================================

    public Booking retrieveBooking(Booking booking) {

        if (booking == null) {

            System.out.println("Booking not found.");
            return null;

        }

        System.out.println("\nBooking Retrieved Successfully");
        System.out.println("PNR : " + booking.getPnr());

        return booking;

    }

    // =====================================================
    // VALIDATE CHECK-IN WINDOW
    // (24 Hours Before Departure to 3 Hours Before)
    // =====================================================

    public boolean validateCheckInWindow(Booking booking) {

        if (booking == null) {

            return false;

        }

        LocalDateTime departure =
                booking.getFlight().getDepartureTime();

        LocalDateTime now = LocalDateTime.now();

        long hours =
                Duration.between(now, departure).toHours();

        if (hours > 24) {

            System.out.println(
                    "Check-in not opened yet.");

            return false;

        }

        if (hours < 3) {

            System.out.println(
                    "Check-in closed.");

            return false;

        }

        System.out.println(
                "Check-in window is valid.");

        return true;

    }

    // =====================================================
    // VERIFY PASSENGER
    // =====================================================

    public boolean verifyPassenger(Passenger passenger) {

        if (passenger == null) {

            System.out.println("Passenger not found.");

            return false;

        }

        if (passenger.getFullName() == null ||
                passenger.getFullName().isBlank()) {

            System.out.println("Passenger name missing.");

            return false;

        }

        if (passenger.getEmail() == null ||
                passenger.getEmail().isBlank()) {

            System.out.println("Passenger email missing.");

            return false;

        }

        System.out.println(
                "Passenger verification successful.");

        return true;

    }

    // =====================================================
    // CONFIRM CURRENT SEAT
    // =====================================================

    public void confirmSeat(Booking booking) {

        if (booking == null) {

            return;

        }

        Seat seat = booking.getSeat();

        if (seat == null) {

            System.out.println(
                    "No seat allocated.");

            return;

        }

        System.out.println("\nCurrent Seat");

        System.out.println(
                "Seat Number : "
                        + seat.getSeatId());

        System.out.println(
                "Seat Type   : "
                        + seat.getSeatType());

    }

    // =====================================================
    // CHANGE SEAT
    // =====================================================

    public void changeSeat(Booking booking,
                           Seat newSeat) {

        if (booking == null || newSeat == null) {

            return;

        }

        if (!newSeat.isAvailable()) {

            System.out.println(
                    "Selected seat is not available.");

            return;

        }

        Seat oldSeat = booking.getSeat();

        if (oldSeat != null) {

            oldSeat.setAvailable(true);
            oldSeat.setStatus("AVAILABLE");

        }

        booking.setSeat(newSeat);

        newSeat.setAvailable(false);
        newSeat.setStatus("BOOKED");

        System.out.println(
                "Seat changed successfully.");

        System.out.println(
                "New Seat : "
                        + newSeat.getSeatId());

    }
    // =====================================================
    // GENERATE BOARDING PASS
    // =====================================================

    public void generateBoardingPass(Booking booking) {

        if (booking == null) {

            return;

        }

        String boardingPass =
                "BP" + System.currentTimeMillis();

        booking.setBoardingPassNumber(boardingPass);

        booking.setCheckInTime(LocalDateTime.now());

        System.out.println("\n======================================");
        System.out.println("       BOARDING PASS GENERATED");
        System.out.println("======================================");
        System.out.println("PNR             : " + booking.getPnr());
        System.out.println("Passenger       : "
                + booking.getPassenger().getFullName());
        System.out.println("Flight          : "
                + booking.getFlight().getFlightNumber());
        System.out.println("Seat            : "
                + booking.getSeat().getSeatId());
        System.out.println("Boarding Pass   : "
                + boardingPass);

    }

    // =====================================================
    // DOWNLOAD BOARDING PASS
    // =====================================================

    public void downloadBoardingPass(Booking booking) {

        if (booking == null) {

            return;

        }

        System.out.println(
                "Boarding Pass downloaded successfully.");

    }

    // =====================================================
    // EMAIL BOARDING PASS
    // =====================================================

    public void emailBoardingPass(Booking booking) {

        if (booking == null) {

            return;

        }

        System.out.println(
                "Boarding Pass sent to "
                        + booking.getPassenger().getEmail());

    }

    // =====================================================
    // UPDATE CHECK-IN STATUS
    // =====================================================

    public void updateCheckInStatus(Booking booking) {

        if (booking == null) {

            return;

        }

        booking.setCheckedIn(true);

        booking.setCheckInTime(LocalDateTime.now());

        System.out.println(
                "Check-In status updated.");

    }

    // =====================================================
    // VALIDATE DOCUMENTS
    // =====================================================

    public boolean validateDocuments(Passenger passenger) {

        if (passenger == null) {

            return false;

        }

        if (passenger.getFullName() == null ||
                passenger.getFullName().isBlank()) {

            System.out.println("Invalid passenger details.");

            return false;

        }

        System.out.println(
                "Passenger documents verified.");

        return true;

    }

    // =====================================================
    // VALIDATE PASSPORT
    // =====================================================

    public boolean validatePassport(Passenger passenger) {

        if (passenger == null) {

            return false;

        }

        if (passenger.getPassport() == null ||
                passenger.getPassport().isBlank()) {

            System.out.println(
                    "Passport verification failed.");

            return false;

        }

        System.out.println(
                "Passport verified.");

        return true;

    }

    // =====================================================
    // BAGGAGE VALIDATION
    // =====================================================

    public void checkBaggageAllowance(Booking booking) {

        if (booking == null) {

            return;

        }

        System.out.println(
                "Cabin Baggage : "
                        + booking.getFlight().getCabinBaggage()
                        + " Kg");

        System.out.println(
                "Check-In Baggage : "
                        + booking.getFlight().getCheckInBaggage()
                        + " Kg");

    }

    // =====================================================
    // SPECIAL ASSISTANCE
    // =====================================================

    public void confirmSpecialAssistance(
            Passenger passenger) {

        if (passenger == null) {

            return;

        }

        System.out.println(
                "Special Assistance : "
                        + passenger.getSpecialAssistance());

    }

    // =====================================================
    // COMPLETE ONLINE CHECK-IN
    // =====================================================

    public void onlineCheckIn(Booking booking) {

        if (booking == null) {

            return;

        }

        Passenger passenger = booking.getPassenger();

        if (!validateCheckInWindow(booking)) {

            return;

        }

        if (!verifyPassenger(passenger)) {

            return;

        }

        if (!validateDocuments(passenger)) {

            return;

        }

        if (!validatePassport(passenger)) {

            return;

        }

        confirmSeat(booking);

        checkBaggageAllowance(booking);

        confirmSpecialAssistance(passenger);

        updateCheckInStatus(booking);

        generateBoardingPass(booking);

        emailBoardingPass(booking);

        downloadBoardingPass(booking);

        System.out.println("\n======================================");
        System.out.println(" ONLINE CHECK-IN COMPLETED SUCCESSFULLY");
        System.out.println("======================================");

    }

}