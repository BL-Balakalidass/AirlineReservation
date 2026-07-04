package service;

import model.*;
import repo.BookingRepo;

import java.util.List;
import model.BookingPriority;
import service.BookingManager;

public class BookingService {

    private BookingRepo bookingRepo;

    public BookingService() {
        bookingRepo = new BookingRepo();
    }

    // Create Booking
    public Booking createBooking(Flight flight) {

        Booking booking = new Booking(flight);

        booking.nextState(); // INITIATED -> PASSENGER_DETAILS

        return booking;
    }

    // Add Passenger
    public void addPassenger(Booking booking, Passenger passenger) {

        booking.addPassenger(passenger);

    }

    // Select Seat
    public void selectSeat(Booking booking, Seat seat) {

        booking.addSeat(seat);

        booking.nextState(); // PASSENGER_DETAILS -> SEAT_SELECTED

    }

    // Calculate Fare
    public void calculateFare(Booking booking) {

        booking.calculateFare();

        booking.nextState(); // SEAT_SELECTED -> PAYMENT_PENDING

    }

    // Confirm Booking
    public void confirmBooking(Booking booking) {

        booking.completePayment();

        bookingRepo.saveBooking(booking);

        System.out.println("\nBooking Confirmed Successfully.");

    }

    // Search by PNR
    public Booking searchByPNR(String pnr) {

        return bookingRepo.getBookingByPNR(pnr);

    }

    // Search by Email
    public List<Booking> searchByEmail(String email) {

        return bookingRepo.getBookingsByEmail(email);

    }

    // Search by Phone
    public List<Booking> searchByPhone(String phone) {

        return bookingRepo.getBookingsByPhone(phone);

    }

    // Display Booking
    public void displayBooking(Booking booking) {

        if (booking == null) {

            System.out.println("Booking Not Found.");
            return;

        }

        booking.displayBooking();

    }

    // Display Booking History
    public void displayBookingHistory() {

        bookingRepo.displayAllBookings();

    }

    // --------------------------------------
// Update Booking
// --------------------------------------

    public void updateBooking(Booking booking) {

        if (booking == null) {

            System.out.println("Booking Not Found.");
            return;

        }

        booking.calculateFare();

        System.out.println("Booking Updated Successfully.");

    }

    // --------------------------------------
// Cancel Booking
// --------------------------------------

    public void cancelBooking(Booking booking) {

        if (booking == null) {

            System.out.println("Booking Not Found.");

            return;
        }

        booking.setBookingState(
                BookingState.CANCELLED);

        System.out.println(
                "Booking Cancelled Successfully.");

    }

    // --------------------------------------
// Display Cancellation
// --------------------------------------

    public void displayCancellation(
            Booking booking) {

        if (booking == null) {

            System.out.println(
                    "Booking Not Found.");

            return;
        }

        booking.displayBooking();

    }

    // -----------------------------------------
// Create Priority Booking
// -----------------------------------------

    public Booking createPriorityBooking(Booking booking,
                                         BookingPriority priority) {

        if (booking == null) {

            return null;

        }

        booking.setPriority(priority);

        booking.setBookingTime(
                System.currentTimeMillis());

        return booking;

    }

    // -----------------------------------------
// Display Booking Priority
// -----------------------------------------

    public void displayBookingPriority(Booking booking) {

        if (booking == null) {

            return;

        }

        System.out.println("PNR : "
                + booking.getPnr());

        System.out.println("Priority : "
                + booking.getPriority());

    }

    // --------------------------------------
// Save Booking
// --------------------------------------

    public void saveBooking(Booking booking) {

        BookingManager
                .getInstance()
                .addBooking(booking);

    }

// --------------------------------------
// Find Booking
// --------------------------------------

    public Booking findBooking(String pnr) {

        return BookingManager
                .getInstance()
                .getBooking(pnr);

    }

// --------------------------------------
// Delete Booking
// --------------------------------------

    public void deleteBooking(String pnr) {

        BookingManager
                .getInstance()
                .removeBooking(pnr);

    }

// --------------------------------------
// Display Cached Bookings
// --------------------------------------

    public void displayCachedBookings() {

        BookingManager
                .getInstance()
                .displayBookings();

    }
}