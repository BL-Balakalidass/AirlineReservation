package service;

import model.Booking;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookingManager {

    // ---------------------------------------
    // Singleton Instance
    // ---------------------------------------

    private static BookingManager instance;

    // ---------------------------------------
    // Booking Cache
    // ---------------------------------------

    private Map<String, Booking> bookingCache;

    // ---------------------------------------
    // Private Constructor
    // ---------------------------------------

    private BookingManager() {

        bookingCache = new HashMap<>();

    }

    // ---------------------------------------
    // Get Singleton Instance
    // ---------------------------------------

    public static synchronized BookingManager getInstance() {

        if (instance == null) {

            instance = new BookingManager();

        }

        return instance;

    }

    // ---------------------------------------
    // Add Booking
    // ---------------------------------------

    public void addBooking(Booking booking) {

        if (booking == null) {

            System.out.println("Invalid Booking.");

            return;

        }

        bookingCache.put(
                booking.getPnr(),
                booking
        );

        System.out.println("Booking Added : "
                + booking.getPnr());

    }

    // ---------------------------------------
    // Get Booking
    // ---------------------------------------

    public Booking getBooking(String pnr) {

        return bookingCache.get(pnr);

    }

    // ---------------------------------------
    // Remove Booking
    // ---------------------------------------

    public void removeBooking(String pnr) {

        if (bookingCache.remove(pnr) != null) {

            System.out.println("Booking Removed : "
                    + pnr);

        } else {

            System.out.println("Booking Not Found.");

        }

    }

    // ---------------------------------------
    // Booking Exists
    // ---------------------------------------

    public boolean containsBooking(String pnr) {

        return bookingCache.containsKey(pnr);

    }

    // ---------------------------------------
    // Total Bookings
    // ---------------------------------------

    public int getBookingCount() {

        return bookingCache.size();

    }

    // ---------------------------------------
    // Get All Bookings
    // ---------------------------------------

    public Collection<Booking> getAllBookings() {

        return bookingCache.values();

    }

    // ---------------------------------------
    // Display All Bookings
    // ---------------------------------------

    public void displayBookings() {

        System.out.println();

        System.out.println("========== BOOKINGS ==========");

        if (bookingCache.isEmpty()) {

            System.out.println("No Bookings Available.");

            return;

        }

        for (Booking booking : bookingCache.values()) {

            System.out.println("--------------------------------");

            System.out.println("PNR : "
                    + booking.getPnr());

            if (booking.getPassenger() != null) {

                System.out.println("Passenger : "
                        + booking.getPassenger().getFullName());

            }

            if (booking.getFlight() != null) {

                System.out.println("Flight : "
                        + booking.getFlight().getFlightNumber());

            }

            System.out.println("Booking State : "
                    + booking.getBookingState());

        }

    }

    // ---------------------------------------
    // Clear Cache
    // ---------------------------------------

    public void clearBookings() {

        bookingCache.clear();

        System.out.println("Booking Cache Cleared.");

    }

}