package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Booking {

    private String bookingId;
    private String pnr;
    private Flight flight;

    private List<Passenger> passengers;
    private List<Seat> seats;

    private BookingState bookingState;

    private double flightFare;
    private double seatCharge;
    private double tax;
    private double totalFare;

    private boolean paymentCompleted;

    public Booking(Flight flight) {

        this.bookingId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.pnr = generatePNR();

        this.flight = flight;

        this.passengers = new ArrayList<>();
        this.seats = new ArrayList<>();

        this.bookingState = BookingState.INITIATED;

        this.paymentCompleted = false;
    }

    private String generatePNR() {

        return "PNR" + (int) (Math.random() * 900000 + 100000);

    }

    // ---------------- Passenger ----------------

    public void addPassenger(Passenger passenger) {

        passengers.add(passenger);

    }

    // ---------------- Seat ----------------

    public void addSeat(Seat seat) {

        seats.add(seat);

    }

    // ---------------- Fare ----------------

    public void calculateFare() {

        seatCharge = 0;

        for (Seat seat : seats) {

            seatCharge += seat.getExtraCharge();

        }

        flightFare = flight.getFare();

        tax = (flightFare + seatCharge) * 0.05;

        totalFare = flightFare + seatCharge + tax;

    }

    // ---------------- State ----------------

    public void nextState() {

        switch (bookingState) {

            case INITIATED:
                bookingState = BookingState.PASSENGER_DETAILS;
                break;

            case PASSENGER_DETAILS:
                bookingState = BookingState.SEAT_SELECTED;
                break;

            case SEAT_SELECTED:
                bookingState = BookingState.PAYMENT_PENDING;
                break;

            case PAYMENT_PENDING:
                if (paymentCompleted) {
                    bookingState = BookingState.CONFIRMED;
                }
                break;

            default:
                break;
        }

    }

    // ---------------- Payment ----------------

    public void completePayment() {

        paymentCompleted = true;
        nextState();

    }

    // ---------------- Display ----------------

    public void displayBooking() {

        System.out.println("\n========== BOOKING DETAILS ==========");

        System.out.println("Booking ID : " + bookingId);
        System.out.println("PNR        : " + pnr);
        System.out.println("Flight     : " + flight.getFlightNumber());
        System.out.println("Passengers : " + passengers.size());

        System.out.print("Seats      : ");

        for (Seat seat : seats) {
            System.out.print(seat.getSeatId() + " ");
        }

        System.out.println();

        System.out.println("Fare        : " + flightFare);
        System.out.println("Seat Charge : " + seatCharge);
        System.out.println("Tax         : " + tax);
        System.out.println("Total Fare  : " + totalFare);

        System.out.println("State       : " + bookingState);

        System.out.println("Payment     : " +
                (paymentCompleted ? "Completed" : "Pending"));

    }

    // ---------------- Getters ----------------

    public String getBookingId() {
        return bookingId;
    }

    public String getPnr() {
        return pnr;
    }

    public Flight getFlight() {
        return flight;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public BookingState getBookingState() {
        return bookingState;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public boolean isPaymentCompleted() {
        return paymentCompleted;
    }

}