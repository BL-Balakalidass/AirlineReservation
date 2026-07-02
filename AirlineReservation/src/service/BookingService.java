package service;

import model.Booking;
import model.Flight;
import model.Passenger;
import model.Seat;
import repo.BookingRepo;

import java.util.List;

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

}