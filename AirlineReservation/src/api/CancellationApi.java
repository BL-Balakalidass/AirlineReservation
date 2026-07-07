package api;

import model.Booking;
import service.BookingCancellationService;

public class CancellationApi {

    private BookingCancellationService
            cancellationService;

    public CancellationApi(
            BookingCancellationService
                    cancellationService) {

        this.cancellationService =
                cancellationService;

    }

    // =====================================================
    // CANCEL BOOKING
    // =====================================================

    public void cancelBooking(
            Booking booking) {

        System.out.println(
                "\n========== CANCELLATION API ==========");

        cancellationService.cancelBooking(
                booking);

    }

    // =====================================================
    // REFUND
    // =====================================================

    public void refundBooking(
            Booking booking) {

        System.out.println(
                "\nRefund Processing...");

        double refund =
                cancellationService
                        .calculateRefundAmount(
                                booking);

        System.out.println(
                "Refund Amount : ₹"
                        + refund);

    }

    // =====================================================
    // RETRIEVE CANCELLATION
    // =====================================================

    public void retrieveCancellation(
            Booking booking) {

        System.out.println(
                "\nCancellation Details");

        System.out.println(
                "PNR : "
                        + booking.getPnr());

        System.out.println(
                "Status : "
                        + booking.getBookingState());

    }

}