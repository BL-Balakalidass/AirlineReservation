package service;

import model.Flight;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class FlightDisplayService {

    private static final DateTimeFormatter DATE_TIME_FORMAT =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    /**
     * Display a list of flights.
     */
    public void displayFlights(List<Flight> flights) {

        if (flights == null || flights.isEmpty()) {

            System.out.println("\nNo flights found.");
            return;
        }

        System.out.println("\n========== AVAILABLE FLIGHTS ==========");

        flights.forEach(this::displayFlight);

        System.out.println("=======================================\n");
    }

    /**
     * Display complete flight details.
     */
    public void displayFlight(Flight flight) {

        System.out.println("----------------------------------------");
        System.out.println("Flight Number      : " + flight.getFlightNumber());
        System.out.println("Airline            : " + flight.getAirline().getAirlineName());
        System.out.println("Aircraft           : " + flight.getAircraft());

        System.out.println();

        System.out.println("Source             : "
                + flight.getSourceAirport().getAirportCode()
                + " - "
                + flight.getSourceAirport().getCity());

        System.out.println("Destination        : "
                + flight.getDestinationAirport().getAirportCode()
                + " - "
                + flight.getDestinationAirport().getCity());

        System.out.println();

        System.out.println("Departure          : "
                + flight.getDepartureTime().format(DATE_TIME_FORMAT));

        System.out.println("Arrival            : "
                + flight.getArrivalTime().format(DATE_TIME_FORMAT));

        System.out.println("Duration           : "
                + flight.getFormattedDuration());

        System.out.println();

        System.out.println("Travel Class       : "
                + flight.getTravelClass());

        System.out.println("Available Seats    : "
                + flight.getAvailableSeats());

        System.out.println("Stops              : "
                + flight.getStops());

        if (flight.getStops() > 0) {

            System.out.println("Layover            : "
                    + flight.getLayoverMinutes()
                    + " minutes");
        }

        System.out.println();

        System.out.println("Fare Details");

        System.out.println("Base Fare          : ₹"
                + flight.getBaseFare());

        System.out.println("Tax                : ₹"
                + flight.getTax());

        System.out.println("Service Charge     : ₹"
                + flight.getServiceCharge());

        System.out.println("Total Fare         : ₹"
                + flight.getTotalFare());

        System.out.println();

        System.out.println("Baggage");

        System.out.println("Cabin              : "
                + flight.getCabinBaggage()
                + " kg");

        System.out.println("Check-in           : "
                + flight.getCheckInBaggage()
                + " kg");

        System.out.println();

        System.out.println("Amenities");

        System.out.println("WiFi               : "
                + yesNo(flight.isWifi()));

        System.out.println("Meals              : "
                + yesNo(flight.isMeals()));

        System.out.println("Entertainment      : "
                + yesNo(flight.isEntertainment()));

        System.out.println();

        System.out.println("Status             : "
                + flight.getStatus());

        System.out.println("Cancellation       : "
                + flight.getCancellationPolicy());

        System.out.println("Modification       : "
                + flight.getModificationPolicy());

        System.out.println("----------------------------------------");
    }

    /**
     * Display a compact summary.
     */
    public void displaySummary(Flight flight) {

        System.out.printf(
                "%-8s %-15s %-10s %-10s %-10s ₹%.2f%n",
                flight.getFlightNumber(),
                flight.getAirline().getAirlineName(),
                flight.getSourceAirport().getAirportCode(),
                flight.getDestinationAirport().getAirportCode(),
                flight.getFormattedDuration(),
                flight.getTotalFare()
        );
    }

    /**
     * Display summaries for multiple flights.
     */
    public void displaySummaryList(List<Flight> flights) {

        if (flights == null || flights.isEmpty()) {

            System.out.println("No Flights Available.");
            return;
        }

        System.out.println();

        System.out.printf(
                "%-8s %-15s %-10s %-10s %-10s %-10s%n",
                "Flight",
                "Airline",
                "Source",
                "Destination",
                "Duration",
                "Fare"
        );

        System.out.println(
                "-----------------------------------------------------------------------");

        flights.forEach(this::displaySummary);

        System.out.println();
    }

    /**
     * Display total number of flights.
     */
    public void displayFlightCount(List<Flight> flights) {

        System.out.println(
                "\nTotal Flights Found : " + flights.size());
    }

    /**
     * Convert boolean to Yes/No.
     */
    private String yesNo(boolean value) {

        return value ? "Yes" : "No";
    }

}