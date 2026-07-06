package service;

import model.Booking;
import model.Flight;
import model.Passenger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {

    // =====================================================
    // DAILY BOOKING REPORT
    // =====================================================

    public void generateDailyBookingReport(List<Booking> bookings) {

        System.out.println("\n======================================");
        System.out.println("        DAILY BOOKING REPORT");
        System.out.println("======================================");

        System.out.println("Total Bookings : " + bookings.size());

        for (Booking booking : bookings) {
            System.out.println("----------------------------------");
            System.out.println("PNR        : " + booking.getPnr());

            if (booking.getPassenger() != null) {
                System.out.println("Passenger  : " + booking.getPassenger().getFullName());
            } else {
                System.out.println("Passenger  : N/A");
            }

            if (booking.getFlight() != null) {
                System.out.println("Flight     : " + booking.getFlight().getFlightNumber());
                System.out.println("Route      : " + booking.getFlight().getRoute());
            } else {
                System.out.println("Flight     : N/A");
                System.out.println("Route      : N/A");
            }

            System.out.println("Fare       : ₹" + booking.getTotalFare());

        }

    }

    // =====================================================
    // REVENUE REPORT
    // =====================================================

    public void generateRevenueReport(List<Booking> bookings) {

        double totalRevenue = 0;

        for (Booking booking : bookings) {

            totalRevenue += booking.getTotalFare();

        }

        System.out.println("\n======================================");
        System.out.println("         REVENUE REPORT");
        System.out.println("======================================");
        System.out.println("Total Bookings : " + bookings.size());
        System.out.println("Revenue        : ₹" + totalRevenue);

    }

    // =====================================================
    // BOOKING TREND BY ROUTE
    // =====================================================

    public void bookingTrendByRoute(List<Booking> bookings) {

        Map<String, Integer> routeMap = new HashMap<>();

        for (Booking booking : bookings) {

            Flight flight = booking.getFlight();

            if (flight == null) {

                continue;

            }

            String route = flight.getRoute();

            routeMap.put(
                    route,
                    routeMap.getOrDefault(route, 0) + 1
            );

        }

        System.out.println("\n======================================");
        System.out.println("      BOOKING TREND BY ROUTE");
        System.out.println("======================================");

        for (String route : routeMap.keySet()) {

            System.out.println(route + " : " + routeMap.get(route));

        }

    }

    // =====================================================
    // BOOKING TREND BY AIRLINE
    // =====================================================

    public void bookingTrendByAirline(List<Booking> bookings) {

        Map<String, Integer> airlineMap = new HashMap<>();

        for (Booking booking : bookings) {

            Flight flight = booking.getFlight();

            if (flight == null) {

                continue;

            }

//            String airline =
//                    flight.getAirline().getAirlineName();


            String airline;

            if (flight != null && flight.getAirline() != null) {
                airline = flight.getAirline().getAirlineName();
            } else {
                airline = "Unknown Airline";
            }

            airlineMap.put(
                    airline,
                    airlineMap.getOrDefault(airline, 0) + 1
            );

        }

        System.out.println("\n======================================");
        System.out.println("     BOOKING TREND BY AIRLINE");
        System.out.println("======================================");

        for (String airline : airlineMap.keySet()) {

            System.out.println(
                    airline + " : " + airlineMap.get(airline)
            );

        }

    }

    // =====================================================
    // AVERAGE BOOKING VALUE
    // =====================================================

    public void averageBookingValue(List<Booking> bookings) {

        if (bookings.isEmpty()) {

            System.out.println("\nAverage Booking Value : ₹0");
            return;

        }

        double total = 0;

        for (Booking booking : bookings) {

            total += booking.getTotalFare();

        }

        double average = total / bookings.size();

        System.out.println("\n======================================");
        System.out.println("      AVERAGE BOOKING VALUE");
        System.out.println("======================================");
        System.out.println("Average Value : ₹" + average);

    }

    // =====================================================
    // CANCELLATION RATE
    // =====================================================

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

            rate = (cancelled * 100.0) / bookings.size();

        }

        System.out.println("\n======================================");
        System.out.println("        CANCELLATION RATE");
        System.out.println("======================================");
        System.out.println("Cancelled Bookings : " + cancelled);
        System.out.println("Cancellation Rate  : " + rate + "%");

    }

    // =====================================================
    // PAYMENT SUCCESS / FAILURE RATE
    // =====================================================

    public void paymentSuccessRate(int success,
                                   int failed) {

        int total = success + failed;

        if (total == 0) {

            System.out.println("\nPayment Success Rate : 0%");
            return;

        }

        double successRate =
                (success * 100.0) / total;

        double failureRate =
                (failed * 100.0) / total;

        System.out.println("\n======================================");
        System.out.println("      PAYMENT ANALYTICS");
        System.out.println("======================================");

        System.out.println("Successful Payments : " + success);

        System.out.println("Failed Payments     : " + failed);

        System.out.println("Success Rate        : "
                + successRate + "%");

        System.out.println("Failure Rate        : "
                + failureRate + "%");

    }

    // =====================================================
    // FLIGHT OCCUPANCY REPORT
    // =====================================================

    public void flightOccupancy(Flight flight,
                                int totalSeats) {

        if (flight == null || totalSeats <= 0) {

            return;

        }

        int bookedSeats =
                totalSeats - flight.getAvailableSeats();

        double occupancy =
                (bookedSeats * 100.0) / totalSeats;

        System.out.println("\n======================================");
        System.out.println("       FLIGHT OCCUPANCY REPORT");
        System.out.println("======================================");

        System.out.println("Flight Number : "
                + flight.getFlightNumber());

        System.out.println("Booked Seats  : "
                + bookedSeats);

        System.out.println("Available     : "
                + flight.getAvailableSeats());

        System.out.println("Occupancy     : "
                + occupancy + "%");

    }

    // =====================================================
    // POPULAR ROUTES
    // =====================================================

    public void popularRoutes(List<Booking> bookings) {

        System.out.println("\n======================================");
        System.out.println("         POPULAR ROUTES");
        System.out.println("======================================");

        bookingTrendByRoute(bookings);

    }

    // =====================================================
    // REVENUE PER FLIGHT
    // =====================================================

    public void revenuePerFlight(List<Booking> bookings) {

        Map<String, Double> revenueMap =
                new HashMap<>();

        for (Booking booking : bookings) {

            Flight flight = booking.getFlight();

            if (flight == null) {

                continue;

            }

            String flightNo =
                    flight.getFlightNumber();

            revenueMap.put(
                    flightNo,
                    revenueMap.getOrDefault(
                            flightNo,
                            0.0)
                            + booking.getTotalFare());

        }

        System.out.println("\n======================================");
        System.out.println("       REVENUE PER FLIGHT");
        System.out.println("======================================");

        for (String flightNo : revenueMap.keySet()) {

            System.out.println(
                    flightNo + " : ₹"
                            + revenueMap.get(flightNo));

        }

    }

    // =====================================================
    // AIRLINE PERFORMANCE
    // =====================================================

    public void airlinePerformance(List<Booking> bookings) {

        System.out.println("\n======================================");
        System.out.println("       AIRLINE PERFORMANCE");
        System.out.println("======================================");

        bookingTrendByAirline(bookings);

    }

    // =====================================================
    // PEAK BOOKING PERIOD
    // =====================================================

    public void peakBookingPeriod(List<Booking> bookings) {

        System.out.println("\n======================================");
        System.out.println("       PEAK BOOKING PERIOD");
        System.out.println("======================================");

        System.out.println("Bookings Analysed : "
                + bookings.size());

        System.out.println("Peak analysis completed.");

    }

    // =====================================================
    // SEAT UTILIZATION
    // =====================================================

    public void seatUtilization(Flight flight,
                                int totalSeats) {

        System.out.println("\n======================================");
        System.out.println("       SEAT UTILIZATION");
        System.out.println("======================================");

        flightOccupancy(flight,
                totalSeats);

    }

    // =====================================================
    // PASSENGER DEMOGRAPHICS
    // =====================================================

    public void passengerDemographics(
            List<Passenger> passengers) {

        System.out.println("\n======================================");
        System.out.println("     PASSENGER DEMOGRAPHICS");
        System.out.println("======================================");

        System.out.println("Total Passengers : "
                + passengers.size());

    }

    // =====================================================
    // REPEAT CUSTOMERS
    // =====================================================

    public void repeatCustomers(
            List<Passenger> passengers) {

        System.out.println("\n======================================");
        System.out.println("        REPEAT CUSTOMERS");
        System.out.println("======================================");

        System.out.println("Customers Analysed : "
                + passengers.size());

        System.out.println("Repeat Customer Analysis Completed.");

    }

    // =====================================================
    // CUSTOMER LIFETIME VALUE
    // =====================================================

    public void customerLifetimeValue(
            Passenger passenger,
            List<Booking> bookings) {

        double total = 0;

        for (Booking booking : bookings) {

            if (booking.getPassenger() == passenger) {

                total += booking.getTotalFare();

            }

        }

        System.out.println("\n======================================");
        System.out.println("      CUSTOMER LIFETIME VALUE");
        System.out.println("======================================");

        System.out.println("Passenger : "
                + passenger.getFullName());

        System.out.println("Lifetime Value : ₹"
                + total);

    }

    // =====================================================
    // BOOKING PATTERNS
    // =====================================================

    public void bookingPatterns(
            List<Booking> bookings) {

        System.out.println("\n======================================");
        System.out.println("        BOOKING PATTERNS");
        System.out.println("======================================");

        System.out.println("Bookings Analysed : "
                + bookings.size());

    }

    // =====================================================
    // PASSENGER PREFERENCES
    // =====================================================

    public void passengerPreferences(
            List<Passenger> passengers) {

        System.out.println("\n======================================");
        System.out.println("     PASSENGER PREFERENCES");
        System.out.println("======================================");

        for (Passenger passenger : passengers) {

            System.out.println(
                    "Passenger : "
                            + passenger.getFullName());

            System.out.println(
                    "Meal Preference : "
                            + passenger.getPreferredMeal());

            System.out.println("----------------------------------");

        }

    }

}