package service;

import model.Booking;
import model.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GDSIntegrationService {

    // =====================================================
    // GDS PROVIDER
    // =====================================================

    private static final String GDS_PROVIDER =
            "Amadeus Global Distribution System";

    // =====================================================
    // SEARCH FLIGHTS
    // =====================================================

    public List<Flight> searchFlights(
            List<Flight> flights,
            String source,
            String destination) {

        System.out.println(
                "\n====================================");

        System.out.println(
                "GDS FLIGHT SEARCH");

        System.out.println(
                "====================================");

        System.out.println(
                "Provider : "
                        + GDS_PROVIDER);

        System.out.println(
                "Route : "
                        + source
                        + " -> "
                        + destination);

        List<Flight> results =
                new ArrayList<>();

        if (flights == null) {

            return results;

        }

        for (Flight flight : flights) {

            if (flight.getSource()
                    .equals(source)
                    &&
                    flight.getDestination()
                            .equals(destination)) {

                results.add(flight);

            }

        }

        System.out.println(
                "Flights Found : "
                        + results.size());

        return results;

    }

    // =====================================================
    // BOOK FLIGHT
    // =====================================================

    public boolean bookFlight(
            Booking booking) {

        if (booking == null) {

            System.out.println(
                    "Booking unavailable.");

            return false;

        }

        System.out.println(
                "\n====================================");

        System.out.println(
                "GDS BOOKING");

        System.out.println(
                "====================================");

        System.out.println(
                "Provider : "
                        + GDS_PROVIDER);

        System.out.println(
                "PNR : "
                        + booking.getPnr());

        System.out.println(
                "Flight : "
                        + booking.getFlight()
                        .getFlightNumber());

        System.out.println(
                "Passenger : "
                        + booking.getPassenger()
                        .getFullName());

        System.out.println(
                "Status : CONFIRMED");

        return true;

    }

    // =====================================================
    // CANCEL BOOKING
    // =====================================================

    public boolean cancelBooking(
            Booking booking) {

        if (booking == null) {

            return false;

        }

        System.out.println(
                "\n====================================");

        System.out.println(
                "GDS BOOKING CANCELLATION");

        System.out.println(
                "====================================");

        System.out.println(
                "PNR : "
                        + booking.getPnr());

        System.out.println(
                "Status : CANCELLED");

        return true;

    }

    // =====================================================
    // SYNC INVENTORY
    // =====================================================

    public void syncInventory(
            List<Flight> flights) {

        System.out.println(
                "\n====================================");

        System.out.println(
                "GDS INVENTORY SYNC");

        System.out.println(
                "====================================");

        if (flights == null) {

            System.out.println(
                    "No Flights Available.");

            return;

        }

        for (Flight flight : flights) {

            System.out.println(
                    "Syncing Flight : "
                            + flight.getFlightNumber());

        }

        System.out.println(
                "Inventory Synchronization Completed.");

    }

    // =====================================================
    // FETCH AVAILABILITY
    // =====================================================

    public int fetchAvailability(
            Flight flight) {

        if (flight == null) {

            return 0;

        }

        System.out.println(
                "\nFetching Availability...");

        System.out.println(
                "Flight : "
                        + flight.getFlightNumber());

        System.out.println(
                "Available Seats : "
                        + flight.getAvailableSeats());

        return flight.getAvailableSeats();

    }

    // =====================================================
    // FETCH REAL-TIME STATUS
    // =====================================================

    public void fetchRealTimeStatus(
            Flight flight) {

        if (flight == null) {

            return;

        }

        System.out.println(
                "\n====================================");

        System.out.println(
                "REAL-TIME FLIGHT STATUS");

        System.out.println(
                "====================================");

        System.out.println(
                "Flight : "
                        + flight.getFlightNumber());

        System.out.println(
                "Status : "
                        + flight.getFlightStatus());

        System.out.println(
                "Last Updated : "
                        + LocalDateTime.now());

    }

    // =====================================================
    // FETCH FLIGHT SCHEDULE
    // =====================================================

    public void fetchSchedule(
            Flight flight) {

        if (flight == null) {

            return;

        }

        System.out.println(
                "\n====================================");

        System.out.println(
                "FLIGHT SCHEDULE");

        System.out.println(
                "====================================");

        System.out.println(
                "Flight : "
                        + flight.getFlightNumber());

        System.out.println(
                "Departure : "
                        + flight.getDepartureTime());

        System.out.println(
                "Arrival : "
                        + flight.getArrivalTime());

    }

    // =====================================================
    // DISPLAY PROVIDER
    // =====================================================

    public void displayProvider() {

        System.out.println(
                "\nConnected GDS Provider : "
                        + GDS_PROVIDER);

    }

}