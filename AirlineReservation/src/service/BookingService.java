package service;

import model.*;
import repo.BookingRepo;

import java.util.List;
import model.BookingPriority;
import exception.BookingNotFoundException;
import exception.BookingSessionExpiredException;
import exception.InvalidPassengerCountException;
import manager.NotificationManager;

import java.time.Duration;
import java.time.LocalDateTime;

public class BookingService {

    private BookingRepo bookingRepo;

    public BookingService() {
        bookingRepo = new BookingRepo();
    }

    // Create Booking
    public Booking createBooking(Flight flight, Passenger passenger) {

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
    private NotificationService notificationService =
            new NotificationService();
    // --------------------------------------
// Booking Notifications
// --------------------------------------

    public void notifyBookingConfirmation(Booking booking) {

        if (booking == null) {

            return;

        }

        notificationService.sendBookingConfirmation(booking);

        notificationService.sendBookingSMS(booking);

    }
    // --------------------------------------
// Flight Notifications
// --------------------------------------

    public void notifyFlightDelay(Flight flight) {

        notificationService.sendDelayNotification(flight);

    }
    public void notifyGateChange(Flight flight,
                                 String gate) {

        notificationService.sendGateChangeNotification(
                flight,
                gate);

    }
    public void notifyCheckIn(Booking booking) {

        notificationService.sendCheckInReminder(
                booking);

    }
    public void notifyBoarding(Booking booking) {

        notificationService.sendBoardingReminder(
                booking);

    }
    private ReportService reportService = new ReportService();

    // =====================================================
// DAILY BOOKING REPORT
// =====================================================

    public void displayDailyBookingReport(List<Booking> bookings) {

        reportService.generateDailyBookingReport(bookings);

    }

// =====================================================
// REVENUE REPORT
// =====================================================

    public void displayRevenueReport(List<Booking> bookings) {

        reportService.generateRevenueReport(bookings);

    }

// =====================================================
// ROUTE ANALYSIS
// =====================================================

    public void displayRouteAnalysis(List<Booking> bookings) {

        reportService.bookingTrendByRoute(bookings);

    }

// =====================================================
// AIRLINE ANALYSIS
// =====================================================

    public void displayAirlineAnalysis(List<Booking> bookings) {

        reportService.bookingTrendByAirline(bookings);

    }

// =====================================================
// AVERAGE BOOKING VALUE
// =====================================================

    public void displayAverageBookingValue(List<Booking> bookings) {

        reportService.averageBookingValue(bookings);

    }

// =====================================================
// CANCELLATION RATE
// =====================================================

    public void displayCancellationRate(List<Booking> bookings) {

        reportService.cancellationRate(bookings);

    }

// =====================================================
// PAYMENT SUCCESS / FAILURE RATE
// =====================================================

    public void displayPaymentSuccessRate(int success,
                                          int failed) {

        reportService.paymentSuccessRate(success, failed);

    }
    private CheckInService checkInService =
            new CheckInService();
    // =====================================================
// VALIDATE BOOKING
// =====================================================

    public boolean validateBookingForCheckIn(
            Booking booking) {

        return checkInService
                .validateCheckInWindow(booking);

    }
    // =====================================================
// ONLINE CHECK-IN
// =====================================================

    public void checkInBooking(
            Booking booking) {

        checkInService.onlineCheckIn(
                booking);

    }
    // =====================================================
// DISPLAY BOARDING PASS
// =====================================================

    public void displayBoardingPass(
            Booking booking) {

        if (booking == null) {

            System.out.println(
                    "Booking not found.");

            return;

        }

        booking.displayBoardingPass();

    }
    // =====================================================
// BUSINESS RULE SERVICE
// =====================================================

    private BusinessRuleService businessRuleService =
            new BusinessRuleService();

    // =====================================================
// CALCULATE FINAL FARE
// =====================================================

    public double calculateFare(
            Booking booking,
            double excessWeight,
            boolean premiumSeat,
            boolean upgradedMeal,
            String couponCode) {

        if (booking == null) {

            return 0;

        }

        double fare =
                businessRuleService.calculateFinalFare(
                        booking.getFlight(),
                        excessWeight,
                        premiumSeat,
                        upgradedMeal,
                        couponCode);

        booking.setTotalAmount(fare);

        booking.setBaggageCharge(
                businessRuleService.calculateBaggageCharges(
                        excessWeight));

        booking.setSeatCharge(
                businessRuleService.calculateSeatCharges(
                        premiumSeat));

        booking.setMealCharge(
                businessRuleService.calculateMealCharges(
                        upgradedMeal));

        if ("FLY500".equalsIgnoreCase(couponCode)) {

            booking.setCouponDiscount(500);

        }
        else {

            booking.setCouponDiscount(0);

        }

        return fare;

    }

    public void displayFareSummary(Booking booking) {
    }

    public void validateBooking(Booking booking, List<Passenger> passengerList) {
    }

    // =====================================================
// EXCEPTION LOGGER
// =====================================================

    private ExceptionLogger logger =
            new ExceptionLogger();

    // =====================================================
// FIND BOOKING
// =====================================================

    public Booking findBooking(
            Booking booking)
            throws BookingNotFoundException {

        if (booking == null) {

            BookingNotFoundException exception =
                    new BookingNotFoundException();

            logger.logException(exception);

            throw exception;

        }

        return booking;

    }
    // =====================================================
// VALIDATE PASSENGER COUNT
// =====================================================

    public void validatePassengerCount(
            int passengerCount)
            throws InvalidPassengerCountException {

        if (passengerCount <= 0 ||
                passengerCount > 6) {

            InvalidPassengerCountException exception =
                    new InvalidPassengerCountException();

            logger.logException(exception);

            throw exception;

        }

        logger.logInfo(
                "Passenger count validated.");

    }
    // =====================================================
// BOOKING SESSION
// =====================================================

    public void validateBookingSession(
            LocalDateTime createdTime)
            throws BookingSessionExpiredException {

        long minutes =
                Duration.between(
                                createdTime,
                                LocalDateTime.now())
                        .toMinutes();

        if (minutes > 30) {

            BookingSessionExpiredException exception =
                    new BookingSessionExpiredException();

            logger.logException(exception);

            throw exception;

        }

        logger.logInfo(
                "Booking session is active.");

    }

    private final NotificationManager notificationManager =
            NotificationManager.getInstance();

    private final GDSIntegrationService gdsService =
            new GDSIntegrationService();

    // =====================================================
// CREATE BOOKING THROUGH GDS
// =====================================================

    public Booking createBookingThroughAPI(
            Flight flight,
            Passenger passenger) {

        Booking booking =
                createBooking(
                        flight,
                        passenger);

        if (booking != null) {

            gdsService.bookFlight(
                    booking);

            notificationManager
                    .sendBookingConfirmation(
                            booking);

        }

        return booking;

    }

    // =====================================================
// RETRIEVE BOOKING USING PNR
// =====================================================

    public Booking retrieveBooking(
            String pnr) {

        return getBookingByPNR(
                pnr);

    }

    public Booking getBookingByPNR(String pnr) {
        return null;
    }
    // =====================================================
// API BOOKING CANCELLATION
// =====================================================

    public void cancelBookingAPI(
            Booking booking,
            BookingCancellationService cancellationService) {

        cancellationService
                .cancelBooking(
                        booking);

        notificationManager
                .sendCancellation(
                        booking);

    }
}