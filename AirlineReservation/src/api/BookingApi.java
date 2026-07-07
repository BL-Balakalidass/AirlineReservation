package api;

import model.Booking;
import model.Flight;
import model.Passenger;
import service.BookingService;

public class BookingApi {

    private BookingService bookingService;

    public BookingApi(
            BookingService bookingService) {

        this.bookingService = bookingService;

    }

    // =====================================================
    // CREATE BOOKING
    // =====================================================

    public Booking createBooking(
            Flight flight,
            Passenger passenger) {

        System.out.println(
                "\n========== CREATE BOOKING API ==========");

        return bookingService.createBooking(
                flight,
                passenger);

    }

    // =====================================================
    // GET BOOKING
    // =====================================================

    public Booking getBooking(
            String pnr) {

        System.out.println(
                "\nRetrieving Booking : "
                        + pnr);

        return bookingService.getBookingByPNR(
                pnr);

    }

    // =====================================================
    // UPDATE BOOKING
    // =====================================================

    public void updateBooking(
            Booking booking) {

        System.out.println(
                "\nUpdating Booking : "
                        + booking.getPnr());

        bookingService.updateBooking(
                booking);

    }

}