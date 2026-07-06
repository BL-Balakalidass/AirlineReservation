package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import model.BookingPriority;

public class Booking  implements Comparable<Booking>{

    // Booking Details
    private String bookingId;
    private String pnr;

    // Flight Details
    private Flight flight;

    // Passenger & Seat Details
    private List<Passenger> passengers;
    private List<Seat> seats;

    // Booking State
    private BookingState bookingState;

    // Fare Details
    private double flightFare;
    private double seatCharge;
    private double tax;
    private double totalFare;

    // Payment Details
    private PaymentStatus paymentStatus;
    private String paymentMethod;
    private String transactionId;

    private boolean paymentCompleted;

    private BookingPriority priority = BookingPriority.REGULAR;

    private long bookingTime;

    // Constructor
    public Booking(Flight flight) {

        this.bookingId =
                UUID.randomUUID()
                        .toString()
                        .substring(0, 8)
                        .toUpperCase();

        this.pnr = generatePNR();

        this.flight = flight;

        passengers = new ArrayList<>();
        seats = new ArrayList<>();

        bookingState = BookingState.INITIATED;

        paymentStatus = PaymentStatus.PENDING;

        paymentMethod = "";

        transactionId = "";

        paymentCompleted = false;
    }

    // Generate PNR
    private String generatePNR() {

        return "PNR"
                + (int) (Math.random() * 900000 + 100000);

    }

    // --------------------------
    // Passenger Operations
    // --------------------------

    public void addPassenger(Passenger passenger) {

        passengers.add(passenger);

    }
    public void removePassenger(Passenger passenger) {

        passengers.remove(passenger);

    }

    public List<Passenger> getPassengers() {

        return passengers;

    }

    // --------------------------
    // Seat Operations
    // --------------------------

    public void addSeat(Seat seat) {

        seats.add(seat);

    }
    public void removeSeat(Seat seat) {

        seats.remove(seat);

    }


    public List<Seat> getSeats() {

        return seats;

    }

    // --------------------------
    // Fare Calculation
    // --------------------------

    public void calculateFare() {

        seatCharge = 0;

        for (Seat seat : seats) {

            seatCharge += seat.getExtraCharge();

        }

        flightFare = flight.getFare();

        tax = (flightFare + seatCharge) * 0.05;

        totalFare =
                flightFare
                        + seatCharge
                        + tax;

    }

    public double getTotalFare() {

        return totalFare;

    }

    // --------------------------
    // Booking State
    // --------------------------

    public void nextState() {

        switch (bookingState) {

            case INITIATED:

                bookingState =
                        BookingState.PASSENGER_DETAILS;

                break;

            case PASSENGER_DETAILS:

                bookingState =
                        BookingState.SEAT_SELECTED;

                break;

            case SEAT_SELECTED:

                bookingState =
                        BookingState.PAYMENT_PENDING;

                break;

            case PAYMENT_PENDING:

                if (paymentCompleted) {

                    bookingState =
                            BookingState.CONFIRMED;

                }

                break;

            default:

                break;
        }

    }

    public BookingState getBookingState() {

        return bookingState;

    }

    public void setBookingState(BookingState bookingState) {

        this.bookingState = bookingState;

    }

    // --------------------------
    // Payment
    // --------------------------

    public void completePayment() {

        paymentCompleted = true;

        nextState();

    }

    public boolean isPaymentCompleted() {

        return paymentCompleted;

    }

    public PaymentStatus getPaymentStatus() {

        return paymentStatus;

    }

    public void setPaymentStatus(
            PaymentStatus paymentStatus) {

        this.paymentStatus = paymentStatus;

    }

    public String getPaymentMethod() {

        return paymentMethod;

    }

    public void setPaymentMethod(
            String paymentMethod) {

        this.paymentMethod = paymentMethod;

    }

    public String getTransactionId() {

        return transactionId;

    }

    public void setTransactionId(
            String transactionId) {

        this.transactionId = transactionId;

    }
    // --------------------------
    // Booking Information
    // --------------------------

    public String getBookingId() {

        return bookingId;

    }

    public String getPnr() {

        return pnr;

    }

    public Flight getFlight() {

        return flight;

    }
    public void setFlight(Flight flight) {

        this.flight = flight;

    }

    // --------------------------
    // Display Booking
    // --------------------------

    public void displayBooking() {

        System.out.println("\n====================================");
        System.out.println("          BOOKING DETAILS");
        System.out.println("====================================");

        System.out.println("Booking ID      : " + bookingId);
        System.out.println("PNR             : " + pnr);

        if (flight != null) {

            System.out.println("Flight Number   : "
                    + flight.getFlightNumber());

        }

        System.out.println("Passengers      : "
                + passengers.size());

        System.out.print("Seats           : ");

        for (Seat seat : seats) {

            System.out.print(seat.getSeatId() + " ");

        }

        System.out.println();

        System.out.println("Flight Fare     : ₹"
                + flightFare);

        System.out.println("Seat Charges    : ₹"
                + seatCharge);

        System.out.println("Tax             : ₹"
                + tax);

        System.out.println("Total Fare      : ₹"
                + totalFare);

        System.out.println("Booking State   : "
                + bookingState);

        System.out.println("Payment Status  : "
                + paymentStatus);

        System.out.println("Payment Method  : "
                + paymentMethod);

        System.out.println("Transaction ID  : "
                + transactionId);

        System.out.println("====================================");

    }

    @Override
    public String toString() {

        return "\nBooking{" +
                "\nbookingId='" + bookingId + '\'' +
                ",\npnr='" + pnr + '\'' +
                ",\nflight=" +
                (flight != null ? flight.getFlightNumber() : "N/A") +
                ",\npassengers=" + passengers.size() +
                ",\nseats=" + seats.size() +
                ",\ntotalFare=" + totalFare +
                ",\nbookingState=" + bookingState +
                ",\npaymentStatus=" + paymentStatus +
                ",\ntransactionId='" + transactionId + '\'' +
                "\n}";
    }

    public BookingPriority getPriority() {

        return priority;

    }

    public void setPriority(BookingPriority priority) {

        this.priority = priority;

    }

    public long getBookingTime() {

        return bookingTime;

    }

    public void setBookingTime(long bookingTime) {

        this.bookingTime = bookingTime;

    }
    @Override
    public int compareTo(Booking other) {

        if (this.priority != other.priority) {

            if (this.priority == BookingPriority.EXPRESS) {

                return -1;

            }

            return 1;

        }

        return Long.compare(this.bookingTime,
                other.bookingTime);

    }


    public void setPnr(String pnr) {

        this.pnr = pnr;

    }



    public String getETicketNumber() {
        return "";
    }

    // --------------------------------------
// Booking Date
// --------------------------------------

    public LocalDateTime getBookingDate() {

        LocalDateTime bookingDate = null;
        return bookingDate;

    }



    public Passenger getPassenger() {
        Passenger passenger = null;
        return passenger;
    }


    // =====================================================
// CHECK-IN DETAILS
// =====================================================

    private boolean checkedIn;

    private String boardingPassNumber;

    private LocalDateTime checkInTime;
    // =====================================================
// CHECK-IN STATUS
// =====================================================

    public boolean isCheckedIn() {

        return checkedIn;

    }

    public void setCheckedIn(boolean checkedIn) {

        this.checkedIn = checkedIn;

    }

// =====================================================
// BOARDING PASS NUMBER
// =====================================================

    public String getBoardingPassNumber() {

        return boardingPassNumber;

    }

    public void setBoardingPassNumber(String boardingPassNumber) {

        this.boardingPassNumber = boardingPassNumber;

    }

// =====================================================
// CHECK-IN TIME
// =====================================================

    public LocalDateTime getCheckInTime() {

        return checkInTime;

    }

    public void setCheckInTime(LocalDateTime checkInTime) {

        this.checkInTime = checkInTime;

    }

    public void displayBoardingPass() {

        System.out.println("\n==================================");
        System.out.println("BOARDING PASS");
        System.out.println("==================================");

        System.out.println("PNR              : " + pnr);
        User passenger;
        System.out.println("Passenger        : " + passenger.getFullName());
        System.out.println("Flight           : " + flight.getFlightNumber());
        System.out.println("Seat             : " + seat.getSeatId());
        System.out.println("Boarding Pass No : " + boardingPassNumber);
        System.out.println("Checked In       : " + checkedIn);
        System.out.println("Check-In Time    : " + checkInTime);

        System.out.println("==================================");

    }




}