package repo;

import model.Booking;
import model.Passenger;

import java.util.ArrayList;
import java.util.List;

public class BookingRepo {

    private List<Booking> bookings;

    public BookingRepo() {
        bookings = new ArrayList<>();
    }

    // Save Booking
    public void saveBooking(Booking booking) {
        bookings.add(booking);
    }

    // Find Booking by PNR
    public Booking getBookingByPNR(String pnr) {

        for (Booking booking : bookings) {

            if (booking.getPnr().equalsIgnoreCase(pnr)) {
                return booking;
            }

        }

        return null;
    }

    // Find Booking by Passenger Email
    public List<Booking> getBookingsByEmail(String email) {

        List<Booking> result = new ArrayList<>();

        for (Booking booking : bookings) {

            for (Passenger passenger : booking.getPassengers()) {

                if (passenger.getEmail().equalsIgnoreCase(email)) {
                    result.add(booking);
                    break;
                }

            }

        }

        return result;
    }

    // Find Booking by Passenger Phone
    public List<Booking> getBookingsByPhone(String phone) {

        List<Booking> result = new ArrayList<>();

        for (Booking booking : bookings) {

            for (Passenger passenger : booking.getPassengers()) {

                if (passenger.getPhone().equals(phone)) {
                    result.add(booking);
                    break;
                }

            }

        }

        return result;
    }

    // Display All Bookings
    public void displayAllBookings() {

        if (bookings.isEmpty()) {

            System.out.println("No Bookings Found.");
            return;

        }

        for (Booking booking : bookings) {
            booking.displayBooking();
        }

    }

    // Get All Bookings
    public List<Booking> getAllBookings() {
        return bookings;
    }

}