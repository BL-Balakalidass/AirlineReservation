package service;

import model.Flight;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightAnalyticsService {

    /**
     * Group flights by Airline.
     */
    public Map<String, List<Flight>> groupFlightsByAirline(
            List<Flight> flights) {

        return flights.stream()
                .collect(Collectors.groupingBy(
                        flight -> flight.getAirline().getAirlineName()
                ));
    }

    /**
     * Group flights by Price Range.
     *
     * Budget     : <= ₹5,000
     * Standard   : ₹5,001 - ₹8,000
     * Premium    : > ₹8,000
     */
    public Map<String, List<Flight>> groupFlightsByPriceRange(
            List<Flight> flights) {

        return flights.stream()
                .collect(Collectors.groupingBy(flight -> {

                    double fare = flight.getTotalFare();

                    if (fare <= 5000) {
                        return "Budget";
                    }

                    if (fare <= 8000) {
                        return "Standard";
                    }

                    return "Premium";

                }));
    }

    /**
     * Group flights by Departure Time Slot.
     *
     * Morning   : 05 - 11
     * Afternoon : 12 - 16
     * Evening   : 17 - 20
     * Night     : 21 - 04
     */
    public Map<String, List<Flight>> groupFlightsByDepartureTimeSlot(
            List<Flight> flights) {

        return flights.stream()
                .collect(Collectors.groupingBy(flight -> {

                    int hour =
                            flight.getDepartureTime().getHour();

                    if (hour >= 5 && hour <= 11) {
                        return "Morning";
                    }

                    if (hour >= 12 && hour <= 16) {
                        return "Afternoon";
                    }

                    if (hour >= 17 && hour <= 20) {
                        return "Evening";
                    }

                    return "Night";

                }));
    }
    /**
     * Calculate average fare by airline.
     */
    public Map<String, Double> calculateAverageFareByAirline(
            List<Flight> flights) {

        return flights.stream()
                .collect(Collectors.groupingBy(
                        flight -> flight.getAirline().getAirlineName(),
                        Collectors.averagingDouble(
                                Flight::getTotalFare
                        )
                ));
    }

    /**
     * Find the cheapest flight for a given route.
     */
    public Flight findCheapestFlightByRoute(
            List<Flight> flights,
            String source,
            String destination) {

        return flights.stream()
                .filter(flight ->
                        flight.getSourceAirport()
                                .getAirportCode()
                                .equalsIgnoreCase(source))
                .filter(flight ->
                        flight.getDestinationAirport()
                                .getAirportCode()
                                .equalsIgnoreCase(destination))
                .min(java.util.Comparator.comparingDouble(
                        Flight::getTotalFare))
                .orElse(null);
    }

    /**
     * Group connecting flights by layover duration.
     */
    public Map<String, List<Flight>> groupConnectingFlightsByLayover(
            List<Flight> flights) {

        return flights.stream()
                .filter(Flight::isConnectingFlight)
                .collect(Collectors.groupingBy(flight -> {

                    int layover = flight.getLayoverMinutes();

                    if (layover <= 60) {
                        return "Short Layover";
                    }

                    if (layover <= 180) {
                        return "Medium Layover";
                    }

                    return "Long Layover";

                }));
    }

    /**
     * Aggregate available seats across all flights.
     */
    public int aggregateAvailableSeats(
            List<Flight> flights) {

        return flights.stream()
                .mapToInt(Flight::getAvailableSeats)
                .sum();
    }

    /**
     * Group flights by journey duration.
     */
    public Map<String, List<Flight>> groupRoundTripByJourneyTime(
            List<Flight> flights) {

        return flights.stream()
                .collect(Collectors.groupingBy(flight -> {

                    long duration =
                            flight.getFlightDuration().toMinutes();

                    if (duration <= 120) {
                        return "Short Journey";
                    }

                    if (duration <= 240) {
                        return "Medium Journey";
                    }

                    return "Long Journey";

                }));
    }

    /**
     * Display grouped flight information.
     */
    public void displayGroupedFlights(
            Map<String, List<Flight>> groupedFlights) {

        groupedFlights.forEach((group, flightList) -> {

            System.out.println("\n========== " + group + " ==========");

            flightList.forEach(flight ->
                    System.out.println(
                            flight.getFlightNumber()
                                    + " | "
                                    + flight.getAirline().getAirlineName()
                                    + " | "
                                    + flight.getRoute()
                                    + " | ₹"
                                    + flight.getTotalFare()));
        });
    }

    /**
     * Display average fare by airline.
     */
    public void displayAverageFare(
            Map<String, Double> averageFareMap) {

        System.out.println("\n===== Average Fare By Airline =====");

        averageFareMap.forEach((airline, fare) ->
                System.out.printf("%-20s : ₹%.2f%n",
                        airline,
                        fare));
    }

    /**
     * Display cheapest flight.
     */
    public void displayCheapestFlight(
            Flight flight) {

        if (flight == null) {

            System.out.println("No Flight Found.");
            return;
        }

        System.out.println("\n===== Cheapest Flight =====");

        System.out.println("Flight Number : "
                + flight.getFlightNumber());

        System.out.println("Airline       : "
                + flight.getAirline().getAirlineName());

        System.out.println("Route         : "
                + flight.getRoute());

        System.out.println("Total Fare    : ₹"
                + flight.getTotalFare());
    }

}