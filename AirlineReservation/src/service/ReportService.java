package service;

import model.Booking;
import model.Flight;
import model.Passenger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {

    // ---------------------------------------
    // Daily Booking Report
    // ---------------------------------------

    public void generateDailyBookingReport(List<Booking> bookings) {

        System.out.println("\n========== DAILY BOOKING REPORT ==========");

        System.out.println("Total Bookings : " + bookings.size());

    }

    // ---------------------------------------
    // Revenue Report
    // ---------------------------------------

    public void generateRevenueReport(List<Booking> bookings) {

        double revenue = 0;

        for (Booking booking : bookings) {

            revenue += booking.getTotalFare();

        }

        System.out.println("\n========== REVENUE REPORT ==========");

        System.out.println("Total Revenue : ₹" + revenue);

    }

    // ---------------------------------------
    // Booking Trend by Route
    // ---------------------------------------

    public void bookingTrendByRoute(List<Booking> bookings) {

        Map<String, Integer> routes = new HashMap<>();

        for (Booking booking : bookings) {

            Flight flight = booking.getFlight();

            if (flight == null) {

                continue;

            }

            String route = flight.getRoute();

            routes.put(route,
                    routes.getOrDefault(route, 0) + 1);

        }

        System.out.println("\n========== BOOKING TREND BY ROUTE ==========");

        for (String route : routes.keySet()) {

            System.out.println(route + " : "
                    + routes.get(route));

        }

    }

    // ---------------------------------------
    // Booking Trend by Airline
    // ---------------------------------------

    public void bookingTrendByAirline(List<Booking> bookings) {

        Map<String, Integer> airlines = new HashMap<>();

        for (Booking booking : bookings) {

            Flight flight = booking.getFlight();

            if (flight == null) {

                continue;

            }

            String airline =
                    flight.getAirline().getAirlineName();

            airlines.put(airline,
                    airlines.getOrDefault(airline, 0) + 1);

        }

        System.out.println("\n========== BOOKING TREND BY AIRLINE ==========");

        for (String airline : airlines.keySet()) {

            System.out.println(airline + " : "
                    + airlines.get(airline));

        }

    }

    // ---------------------------------------
    // Average Booking Value
    // ---------------------------------------

    public void averageBookingValue(List<Booking> bookings) {

        if (bookings.isEmpty()) {

            System.out.println("Average Booking Value : ₹0");

            return;

        }

        double total = 0;

        for (Booking booking : bookings) {

            total += booking.getTotalFare();

        }

        System.out.println("\nAverage Booking Value : ₹"
                + (total / bookings.size()));

    }

    // ---------------------------------------
    // Cancellation Rate
    // ---------------------------------------

    public void cancellationRate(List<Booking> bookings) {

        int cancelled = 0;

        for (Booking booking : bookings) {

            if (booking.getBookingState()
                    .toString()
                    .equalsIgnoreCase("CANCELLED")) {

                cancelled++;

            }

        }

        double rate = 0;

        if (!bookings.isEmpty()) {

            rate = (cancelled * 100.0)
                    / bookings.size();

        }

        System.out.println("\nCancellation Rate : "
                + rate + "%");

    }

    // ---------------------------------------
    // Payment Success Rate
    // ---------------------------------------

    public void paymentSuccessRate(int success,
                                   int failed) {

        int total = success + failed;

        if (total == 0) {

            System.out.println("\nPayment Success Rate : 0%");

            return;

        }

        double rate =
                (success * 100.0) / total;

        System.out.println("\nPayment Success Rate : "
                + rate + "%");

    }

    // ---------------------------------------
    // Flight Occupancy
    // ---------------------------------------

    public void flightOccupancy(Flight flight,
                                int totalSeats) {

        if (flight == null) {

            return;

        }

        int booked =
                totalSeats - flight.getAvailableSeats();

        double occupancy =
                (booked * 100.0) / totalSeats;

        System.out.println("\n========== OCCUPANCY ==========");

        System.out.println("Flight : "
                + flight.getFlightNumber());

        System.out.println("Occupancy : "
                + occupancy + "%");

    }

    // ---------------------------------------
    // Popular Routes
    // ---------------------------------------

    public void popularRoutes(List<Booking> bookings) {

        bookingTrendByRoute(bookings);

    }

    // ---------------------------------------
    // Revenue Per Flight
    // ---------------------------------------

    public void revenuePerFlight(List<Booking> bookings) {

        Map<String, Double> revenue =
                new HashMap<>();

        for (Booking booking : bookings) {

            Flight flight = booking.getFlight();

            if (flight == null) {

                continue;

            }

            String number =
                    flight.getFlightNumber();

            revenue.put(number,

                    revenue.getOrDefault(number,
                            0.0)

                            + booking.getTotalFare());

        }

        System.out.println("\n========== REVENUE PER FLIGHT ==========");

        for (String flight : revenue.keySet()) {

            System.out.println(flight
                    + " : ₹"
                    + revenue.get(flight));

        }

    }

    // ---------------------------------------
    // Airline Performance
    // ---------------------------------------

    public void airlinePerformance(List<Booking> bookings) {

        bookingTrendByAirline(bookings);

    }

    // ---------------------------------------
    // Peak Booking Period
    // ---------------------------------------

    public void peakBookingPeriod(List<Booking> bookings) {

        System.out.println();

        System.out.println("Peak Booking Period Analysis");

        System.out.println("Bookings Analysed : "
                + bookings.size());

    }

    // ---------------------------------------
    // Seat Utilization
    // ---------------------------------------

    public void seatUtilization(Flight flight,
                                int totalSeats) {

        flightOccupancy(flight,
                totalSeats);

    }

    // ---------------------------------------
    // Passenger Demographics
    // ---------------------------------------

    public void passengerDemographics(
            List<Passenger> passengers) {

        System.out.println();

        System.out.println("Passenger Count : "
                + passengers.size());

    }

    // ---------------------------------------
    // Repeat Customers
    // ---------------------------------------

    public void repeatCustomers(
            List<Passenger> passengers) {

        System.out.println();

        System.out.println("Repeat Customer Analysis Completed.");

    }

    // ---------------------------------------
    // Customer Lifetime Value
    // ---------------------------------------

    public void customerLifetimeValue(
            Passenger passenger,
            List<Booking> bookings) {

        double total = 0.0;

        for (Booking booking : bookings) {
            if (booking.getPassenger() == passenger) {
                total += booking.getTotalFare();
            }


        }

        System.out.println();

        System.out.println("Customer : "
                + passenger.getFullName());

        System.out.println("Lifetime Value : ₹"
                + total);

    }

    // ---------------------------------------
    // Booking Pattern
    // ---------------------------------------

    public void bookingPatterns(
            List<Booking> bookings) {

        System.out.println();

        System.out.println("Booking Pattern Report");

        System.out.println("Bookings : "
                + bookings.size());

    }

    // ---------------------------------------
    // Passenger Preference Report
    // ---------------------------------------

    public void passengerPreferences(
            List<Passenger> passengers) {

        System.out.println();

        System.out.println("Passenger Preference Report");

        for (Passenger passenger : passengers) {

            System.out.println(
                    passenger.getFullName()
                            + " -> Meal : "
                            + passenger.getPreferredMeal());

        }

    }

}